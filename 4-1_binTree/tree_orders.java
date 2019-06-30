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
    
    
    // Node class ===============================
    public class Node<T> {
    	private T keyVal = null;   	    	
    	private Node<T> leftNode = null;
    	private Node<T> rightNode = null;
    	
    	// Base constructor
    	public Node() {    		
    	}
    	    	
    	// Set keyVal
    	public void setKey(T k) {
            this.keyVal = k;
    	}
    	
    	public T getKey() {
    		return keyVal;
    	}
    	
    	// Set leftNode
    	public void setLeftPtr(Node<T> lNode) {
    		this.leftNode = lNode;
    	}
    	
    	public Node<T> getLeftPtr(){
    		return leftNode;
    	}
    	
    	// Set rightNode
    	public void setRightPtr(Node<T> rNode) {
    		this.rightNode = rNode;
    	}
    	
    	public Node<T> getRightPtr(){
    		return rightNode;
    	}
    	
    } // end Node class
    
  
  // TreeOrders class ===========================
	public class TreeOrders {
		
		int n;
		int[] key, left, right;
		
		// Create ArrayList of Nodes
		List<Node<Integer>> nodes;
		
		
		// Read function ----------------------------
		void read() throws IOException {
			FastScanner in = new FastScanner();
			
			// Allocate ArrayList of Nodes
			nodes = new ArrayList<>();
			
			// Get number of vertices
			n = in.nextInt();
			
			// Allocate nodes
			for (int i = 0; i < n; i++) { 
				Node<Integer> node = new Node<>();
				nodes.add(node); 
			}
						
			
			// Create arrays of node elements
			// key = new int[n];
			// left = new int[n];
			// right = new int[n];
			
			
			// Read in tree vertices and 
			// create array of nodes
			for (int i = 0; i < n; i++) { 
				
				// Set node key value
				Node<Integer> node = nodes.get(i);
				node.setKey(in.nextInt());
				
				// Set node left child ptr
				int l = in.nextInt();
				if (l > -1) {
					// Node<Integer> lNode = nodes.get(l);
					node.setLeftPtr(nodes.get(l));
				}
				
				// Set node right child ptr
				int r = in.nextInt();
				if (r > -1) {
					// Node<Integer> rNode = nodes.get(r);
					node.setRightPtr(nodes.get(r));
				}
				
				// Add node back into list
				nodes.set(i, node);
				
			} // end for
			
			
			/* Old read in data struct
			// Read in node elements
			for (int i = 0; i < n; i++) { 
				key[i] = in.nextInt();
				left[i] = in.nextInt();
				right[i] = in.nextInt();
			}
			*/
			
			
		} // end read
		
		
    // In Order Traversal function --------------
		List<Integer> inOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			
			for(int i = 0; i < nodes.size(); i++) {
				System.out.print(nodes.get(i).getKey() + " ");
			}
			System.out.print("\n");
			
			/*
			// debug: print key input
			for(int i = 0; i < key.length; i++) {
				System.out.print(key[i] + " ");
			}
			System.out.print("\n");
			*/
			
			
			/*
            // debug: print result list            
            for (int i = 0; i < result.size(); i++) {
            	System.out.print(result.get(i) + " ");
            }
            System.out.print("\n");
            */
			
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
		
		// Create tree
		TreeOrders tree = new TreeOrders();
		tree.read();
		
		// Print traversals
		print(tree.inOrder());
		print(tree.preOrder());
		print(tree.postOrder());
		
	} // end run
	
	
} // end tree_orders class




