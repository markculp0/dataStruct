import java.util.*;
import java.io.*;
import java.util.Queue; 

public class tree_height {
	
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
	} // end FastScanner class 
    
    // Node class for tree elements
    public class Node<T>{
    	
    	private T data = null;
    	private int level = 0;
    	private Node<T> parentPointer = null;
    	private List<Node<T>> childPointer = new ArrayList<>();
    	   
    	
    	// Constructors
        public Node() {			
		}
        
    	public Node(T data) {
            this.data = data;
        }
    	
    	public void setLevel(int l) {
    		this.level = l;
    	}
    	
    	public int getLevel() {
    		return level;
    	}
        
        // Data 
		public void setData(T data) {
            this.data = data;
        }
    	
        public T getData() {
            return data;
        }           
        
        // Parent pointer
        public void setParentPointer(Node<T> parentPointer) {
            this.parentPointer = parentPointer;
        }
                
        public Node<T> getParentPointer() {
        	return parentPointer;
        }
        
        // Children pointers
        public void setChildPointer(Node<T> child) {
        	child.setParentPointer(this);
        	this.childPointer.add(child);        	
        }
        
        public List<Node<T>> getChildPointer(){
        	return childPointer;
        }
        
        // Is node a leaf?
        boolean hasChildren() {
        	return (childPointer.size() > 0);
        }
                        
    } // end Node class
    
    
    // Class to build tree, traverse tree, 
    // and calculate height
	public class TreeHeight {
		int n;
		int parent[];
		
		// Read in tree data
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
			}
			
			/*
			// debug: view indexes and values of input
			System.out.print("| ");
			for (int i = 0; i < n; i++) {
				System.out.print(Integer.toString(i) + ":" + parent[i] + " | ");
			}
			System.out.print("\n");
			*/
			
			
		}  // end read()
		
				
		int computeHeight() {
			
			int rootNode = 0;
			
			// Create ArrayList of Nodes
			List<Node<Integer>> nodes = new ArrayList<>();
									
			// Allocate nodes
			for (int i = 0; i < n; i++) { 
				Node<Integer> node = new Node<>();
				nodes.add(node); 
			}			
			
			// Build the tree and
			// Set node variables
			for (int i = 0; i < n; i++) {				
				
				if (parent[i] == -1) {
					
					// Set root node						
					Node<Integer> root = nodes.get(i);
					root.setData(i);					
					nodes.set(i, root);
					rootNode = i;
					
				}
				else {
					
					// Set node's data and parent value
					Node<Integer> node = nodes.get(i);
					node.setData(i);  					
					Node<Integer> pNode = nodes.get(parent[i]);					
					node.setParentPointer(pNode);  
					
					// Add node to array
					nodes.set(i, node);
					
					// Set parent and child pointers					
					pNode.setChildPointer(node);
					nodes.set(parent[i], pNode);
									
				} // end else
				
			}  // end for
			
			
			
			// Breadth first Traversal
			Node<Integer> node = nodes.get(rootNode);
			if (!node.hasChildren())
				return 1;
			
			Queue<Node<Integer>> q = new LinkedList<>(); 
			
			// Enqueue root node
			node.setLevel(1);
			q.add(node);
			
			int height = 0;
			
			// Traverse nodes 
			while (!q.isEmpty()) {
				
				// Dequeue node 
				Node<Integer> nodeNext = q.poll();
				// Check node level for new height 
				if (nodeNext.getLevel() > height)
					height = nodeNext.getLevel();
				
				// Enqueue children nodes
				if (nodeNext.hasChildren()) {
					List<Node<Integer>> children = nodeNext.getChildPointer();
					for (int i = 0; i < children.size(); i++) {
						// Set child node level, enqueue node
						children.get(i).setLevel(nodeNext.getLevel() + 1);  
						q.add(children.get(i));						
						// System.out.print(Integer.toString(children.get(i).getData()));
						
					}  // end for
				} // end if								
				// System.out.print("|");
				
			} // end while q not empty
									
			
			return height;
		} // end computeHeight

		
		// Provided slower solution
		/*
		int computeHeight() {
						
            // Replace this code with a faster implementation
			int maxHeight = 0;
			for (int vertex = 0; vertex < n; vertex++) {
				int height = 0;
				for (int i = vertex; i != -1; i = parent[i])
					height++;
				maxHeight = Math.max(maxHeight, height);
			}
			return maxHeight;			
			
		} // end computeHeight()
		*/
		
	}  // end TreeHeight class
	

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}  // end main
	
	
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
		
	}  // end run
	
	
} // end tree_height class


