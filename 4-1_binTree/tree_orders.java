import java.util.*;
import java.io.*;

public class tree_orders {
  
  
    // FastScanner class ========================
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;
    
    // Constructor ------------------------------
		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}
    
    // next function ----------------------------
		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
	  
	  // nextInt function --------------------------
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	} // end FastScanner class
  
  
  // TreeOrders class ===========================
	public class TreeOrders {
		int n;
		int[] key, left, right;
		
		
		// Read function ----------------------------
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			key = new int[n];
			left = new int[n];
			right = new int[n];
			for (int i = 0; i < n; i++) { 
				key[i] = in.nextInt();
				left[i] = in.nextInt();
				right[i] = in.nextInt();
			}
		} // end read
		
		
    // In Order Traversal function --------------
		List<Integer> inOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
                        
			return result;
		} // end inOrder
    
    
    // Pre Order Traversal ----------------------
		List<Integer> preOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
                        
			return result;
		} // end preOrder
    
    
    // Post Order Traversal ---------------------
		List<Integer> postOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
                        
			return result;
		} // end postOrder function
		
		
	} // end TreeOrders class
	

  // Main function ------------------------------
	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_orders().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	} // end main
	

  // print function -----------------------------
	public void print(List<Integer> x) {
		for (Integer a : x) {
			System.out.print(a + " ");
		}
		System.out.println();
	}  // end print


  // run function -------------------------------
	public void run() throws IOException {
		TreeOrders tree = new TreeOrders();
		tree.read();
		print(tree.inOrder());
		print(tree.preOrder());
		print(tree.postOrder());
	} // end run
	
	
} // end tree_orders class




