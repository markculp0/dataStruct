import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class HashChains {

	// Input/output
    private FastScanner in;
    private PrintWriter out;
    
    // store all strings in one list
    private ArrayList<ArrayList<String>> elems;
    
    // For hash function
    private int bucketCount;
    private int prime = 1000000007;
    private int multiplier = 263;

    
    // Main method
    public static void main(String[] args) throws IOException {
        new HashChains().processQueries();
    } // end main

    
    // hashFunc method
    private int hashFunc(String s) {
        long hash = 0;
        for (int i = s.length() - 1; i >= 0; --i)
            hash = (hash * multiplier + s.charAt(i)) % prime;
        return (int)hash % bucketCount;
    } // end hashFunc
    

    // readQuery method
    private Query readQuery() throws IOException {
    	
        String type = in.next();
        
        // add, del or find
        if (!type.equals("check")) {
            String s = in.next();
            return new Query(type, s);
        // check    
        } else {
            int ind = in.nextInt();
            return new Query(type, ind);
        }
    }  // end readQuery

    
    // writeSearchResult method
    private void writeSearchResult(boolean wasFound) {
        out.println(wasFound ? "yes" : "no");
        // Uncomment the following if you want to play with the program interactively.
        // out.flush();
    } // end writeSearchResult

    
    // processQuery method
    private void processQuery(Query query) {
    	int index;
    	
        switch (query.type) {
            case "add":
            	index = hashFunc(query.s);
                if (!elems.get(index).contains(query.s))
                    elems.get(index).add(0, query.s);
                break;
            case "del":
            	index = hashFunc(query.s);
                if (elems.get(index).contains(query.s))
                    elems.get(index).remove(query.s);
                break;
            case "find":
            	index = hashFunc(query.s);
                writeSearchResult(elems.get(index).contains(query.s));
                break;
            case "check":
            	for (int i = 0; i < elems.get(query.ind).size(); i++)
            		out.print(elems.get(query.ind).get(i) + " ");
                out.println();
                // Uncomment the following if you want to play with the program interactively.
                // out.flush();
                break;
            default:
                throw new RuntimeException("Unknown query: " + query.type);
        }
    } // end processQuery

    
    // processQueries method
    public void processQueries() throws IOException {
    	
        elems = new ArrayList<ArrayList<String>>();
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
                       
        bucketCount = in.nextInt();
        
        // Create ArrayList of ArrayLists
        for (int i = 0; i < bucketCount; i++) {
        	ArrayList<String> chain = new ArrayList<String>();
        	elems.add(chain);
        }
                
        // Process queries
        int queryCount = in.nextInt();
        for (int i = 0; i < queryCount; ++i) {
            processQuery(readQuery());
        }
                        
        /*
        // Test hash function
        bucketCount = 5;
        String word = "world";
        int hash = hashFunc(word);
        out.println(hash);
        */
                
        out.close();
    } // end processQueries

    
    // Query class
    static class Query {
        String type;
        String s;
        int ind;

        public Query(String type, String s) {
            this.type = type;
            this.s = s;
        }

        public Query(String type, int ind) {
            this.type = type;
            this.ind = ind;
        }
    } // end Query class

    
    // FastScanner class
    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    } // end FastScanner class
    
} // end HashChains class


