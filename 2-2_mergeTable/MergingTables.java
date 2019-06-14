import java.io.*;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

public class MergingTables {
    private final InputReader reader;
    private final OutputWriter writer;
    

    public MergingTables(InputReader reader, OutputWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }
    
    
    // Main function
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        OutputWriter writer = new OutputWriter(System.out);
        new MergingTables(reader, writer).run();
        writer.writer.flush();
    }  // end Main
    
    
    
    // Table class
    class Table {
        Table parent;
        int rank;
        long numberOfRows;
        int tableNumber;
        
        // Table constructor
        Table(int numberOfRows, int tableNumber) {
            this.numberOfRows = numberOfRows;
            this.tableNumber = tableNumber;
            rank = 0;
            parent = this;
        } //  end Table
                
        // Get Rows
        long getRows() {
        	return numberOfRows;
        } // end getRows
        
        // Add Rows
        void addRows(long r) {
        	numberOfRows = numberOfRows + r;
        } // end addRows
        
        // Remove Rows
        void removeRows() {
        	numberOfRows = 0;
        } // end removeRows
        
        // Get Rank
        int getRank() {
        	return rank;
        }  // end getRank
        
        void incrRank() {
        	rank = rank + 1;
        }
        
        // Get Table Number
        int getTableNumber() {
        	return tableNumber;
        }
                
        // Get Parent
        Table getParent() {
            // find super parent and compress path    
        	
        	if (parent.getTableNumber() != this.getTableNumber())
        		parent = parent.getParent();
            return parent;
        }
        
        // Set Parent
        void setParent(Table t) {
        	parent = t;
        }
        
    }  // end Table class
    

    
    long maximumNumberOfRows = -1;
    

    // Merge tables
    void merge(Table destination, Table source) {
    	
        Table realDestination = destination.getParent();
        /*
        if(realDestination.getTableNumber() != destination.getTableNumber()) {
        	while(realDestination.getTableNumber() != realDestination.getParent().getTableNumber()) {
        		realDestination = realDestination.getParent();
        	}
        }
        */
        	        
        Table realSource = source.getParent();
        /*
        if(realSource.getTableNumber() != source.getTableNumber()) {
        	while(realSource.getTableNumber() != realSource.getParent().getTableNumber()) {
        		realSource = realSource.getParent();
        	}
        }
        */
        
        if (realDestination == realSource) {
            return;
        }
     
        // Merge rows from src to dst
        realDestination.addRows(realSource.getRows());
        realSource.removeRows();
        
        // Increase dest rank
        realDestination.incrRank();
        realSource.setParent(realDestination);
        
        
        /*        
        // debug 
        writer.printf("Dst: Rows %d Rank %d | ", realDestination.getRows(), realDestination.getRank());
        writer.printf("Src: Rows %d Rank %d ", realSource.getRows(), realSource.getRank());
        */
                
        
        // use rank heuristic
        
        
        // update maximumNumberOfRows
        maximumNumberOfRows = Math.max(maximumNumberOfRows, realDestination.getRows());
        
        
    }  // end merge
    
    
    
    // Run 
    public void run() {
        int n = reader.nextInt();
        int m = reader.nextInt();
        int numberOfRows = 0;		// init 0
        
        Table[] tables = new Table[n];
        for (int i = 0; i < n; i++) {
            numberOfRows = reader.nextInt();
            tables[i] = new Table(numberOfRows, i + 1);
            maximumNumberOfRows = Math.max(maximumNumberOfRows, numberOfRows);
        }
        
        // Cycle thru merge operations
        for (int i = 0; i < m; i++) {
            int destination = reader.nextInt() - 1;
            int source = reader.nextInt() - 1;                        
            
            merge(tables[destination], tables[source]);
            
            /*
            // debug
            writer.printf(" | MaxRow%d: %d |", i, maximumNumberOfRows);
            for (int j = 0; j < n; j++) {
            	writer.printf("| t%d rw:%d rk:%d p:%d", j + 1, 
            			tables[j].getRows(), tables[j].getRank(), 
            			tables[j].getParent().getTableNumber());
            }
            writer.printf("\n");
            */
            
            // Orig writer
            writer.printf("%d\n", maximumNumberOfRows);
        }
    }  // end Run()

    
    // InputReader class
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    } // end InputReader class
    
    
    // OutputWriter class
    static class OutputWriter {
        public PrintWriter writer;

        OutputWriter(OutputStream stream) {
            writer = new PrintWriter(stream);
        }

        public void printf(String format, Object... args) {
            writer.print(String.format(Locale.ENGLISH, format, args));
        }
    } // end OutputWriter class
    
    
    
}  // end MergingTables class
