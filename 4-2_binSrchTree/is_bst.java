import java.util.*;
import java.io.*;

// is_bst class
public class is_bst {
    
    // FastScanner class ========================
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        
    }  // end FastScanner class
    

    
    
    // IsBST class ==============================
    public class IsBST {
      
        // Node class ===========================
        class Node {
            int key;
            int left;
            int right;

            Node(int key, int left, int right) {
                this.left = left;
                this.right = right;
                this.key = key;
            }
        } // end Node class
        

        int nodes;
        Node[] tree;
        
        
        // Read method --------------------------
        void read() throws IOException {
            FastScanner in = new FastScanner();
            nodes = in.nextInt();
            
            if (nodes == 0) {
            	System.out.println("CORRECT");
            	System.exit(0);
            }
            
            tree = new Node[nodes];
            
            for (int i = 0; i < nodes; i++) {
            	
                tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
            }
        } // end read
        
        
        // Recursive is it BST method
        boolean bst(Node root, Node left, Node right) {
        	
        	// Check base case
        	if (root == null || root.key == -1)
        		return true;
        	
        	// Check if root key < left node's key
        	if (left != null && left.key != -1 && root.key < left.key)
        		return false;
        	
        	// Check if root key > right node's key
        	if (right != null && right.key != -1 && root.key > right.key)
        		return false;
        	
        	// Set left node
        	Node treeLeft;
        	if (root.left == -1)
        		treeLeft = null;
        	else 
        		treeLeft = tree[root.left];
        	
        	// Set right node
        	Node treeRight;
        	if (root.right == -1)
        		treeRight = null;
        	else
        		treeRight = tree[root.right];
        	
        	// Recurse through correct comparisons
        	return bst(treeLeft, left, root) &&
        			bst(treeRight, root, right);
        }
                
        
        // isBinarySearchTree method ------------
        boolean isBinarySearchTree() {
                      	                  	
          /*	
          // debug: print tree keys	
          for (int i = 0; i < tree.length; i++) {
        	  System.out.print(tree[i].key + " ");
          }
          System.out.print("\n");
          */
        	
          return bst(tree[0], null, null);
        } // end isBinarySearchTree
        
        
    } // end IsBST class
    

    // Main method ------------------------------
    static public void main(String[] args) throws IOException {
      
        new Thread(null, new Runnable() {
          
            public void run() {
                try {
                  
                    new is_bst().run();
                    
                } catch (IOException e) {
                  
                }
            }   // end run
        }, "1", 1 << 26).start();
        
    } // end main
    
    
    // Run method -------------------------------
    public void run() throws IOException {
      
        IsBST tree = new IsBST();
        tree.read();
        
        if (tree.isBinarySearchTree()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }  // end run
    
    
} // end is_bst class
