import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class BuildHeapStressTest {
	
	private int size;
    private int[] data;
    private List<Swap> swaps;

    private FastScanner in;
    private PrintWriter out;
    
    // Main function
    public static void main(String[] args) throws IOException {
        new BuildHeapStressTest().solve();
    } // end main
    

    // readData function
    private void readData() throws IOException {
        int n = in.nextInt();
        data = new int[n];
        for (int i = 0; i < n; ++i) {
          data[i] = in.nextInt();
        }
    } // end readData

    
    // writeResponse function
    private void writeResponse() {
        out.println(swaps.size());
        for (Swap swap : swaps) {
          out.println(swap.index1 + " " + swap.index2);
        }
    } // end writeResponse
    
    
    // leftChild function
    private int leftChild(int i) {
    	return 2 * i + 1;
    } // end leftChild
    
    
    // rightChild function
    private int rightChild(int i) {
    	return 2 * i + 2;
    } // end rightChild
    
    
    // siftDown function
    private int siftDown(int i) {
    	int minIndex = i;
    	
    	// Compare left child
    	if (leftChild(i) < size) {
    		
    		int left = leftChild(i);    	
    		if ((left <= size) && (data[left] < data[minIndex]))
    			minIndex = left;
    	}
    	
    	
    	// Compare right child    	
    	if (rightChild(i) < size) {
    		
    		int right = rightChild(i);
    		if ((right <= size) && (data[right] < data[minIndex]))
    			minIndex = right;
    	}
    	
    	// Perform swaps
    	if (i != minIndex) {
    		swaps.add(new Swap(i, minIndex));
    		int tmp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = tmp;
    		
            siftDown(minIndex);
    	}
    	
    	// System.out.println("MinIdx: " + minIndex);
    	
    	return i;
    }  // end SiftDown
    

    // generateSwaps function
    private void generateSwaps() {
    	
      swaps = new ArrayList<Swap>();
      
      size = data.length;
      int halfSz = size / 2 - 1;
      
      for (int i = halfSz; i > -1; --i) {
    	  // System.out.println("Index: " + i);
    	  siftDown(i);
      }
      
      // System.out.println(halfSz);            
      
      
    } // end generateSwaps
    
    
    // solve function
    public void solve() throws IOException {
        // in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        // readData();
        
        while(true) {
        
        // Generate random input
        int n = (int)(Math.random() * 6) + 1;                
        data = new int[n];
        for (int i = 0; i < n; ++i) {
          data[i] = (int)(Math.random() * 10) + 1;
        }        
        
        
        // Print input 
        System.out.print("input: ");
        for (int i = 0; i < n; ++i) {
        	
        	
        	System.out.print(data[i] + " ");
        }
        System.out.print("\n");
        
        generateSwaps();        
        
       
        // Print Binary Heap Tree
        System.out.print("heap: ");
        for (int i = 0; i < n; ++i) {
        	        	
        	System.out.print(data[i] + " ");
        	
        	// test left child
        	if (leftChild(i) < size) {
        		if (data[leftChild(i)] < data[i]) {
        			break;
        		}
        	} // end if
        	
        	// test right child
        	if (rightChild(i) < size) {
        		if (data[rightChild(i)] < data[i]) {
        			break;
        		}
        	} // end if
        	
        	
        }
        System.out.print("\n");
        
        } // end while
        
         
        // writeResponse();
        // out.close();
        
        
    }  // end solve

    
    // Swap class
    static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    } // end Swap class

    
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
        
    }  // end FastScanner class
    
    
} // end BuildHeap class


