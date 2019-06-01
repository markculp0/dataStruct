import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
  
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }
    
    // Get bracket character
    char getType() {
    	return this.type;
    }
    
    // Get bracket position    
    int getPosition() {
    	return this.position;
    }

    char type;
    int position;
}

class check_brackets {
	
	public static void main(String[] args) throws IOException {
		
		InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();
		
		String result = myMain(text);
		System.out.println(result);
		
	}
	
	// Process string
    public static String myMain(String textStr) throws IOException {
                      
        Bracket top = new Bracket('z',0);
        String msg ="Success";
        
        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        
        // For length of input string
        for (int position = 0; position < textStr.length(); ++position) {
        	
        	// Get next char
            char next = textStr.charAt(position);
            
            // If opening bracket
            if (next == '(' || next == '[' || next == '{') {
            	
                // Process opening bracket
            	Bracket brkt = new Bracket(next, position);
                opening_brackets_stack.push(brkt);
                
                
            } // end if
            
            // Else if closing bracket
            else {
            	
            	if (next == ')' || next == ']' || next == '}') {
            		
            		// No matching bracket on stack
	            	if (opening_brackets_stack.isEmpty()) {
	            		
	            		// Return location of unmatched closing bracket
	            		position = position + 1;
	            		msg = Integer.toString(position);
	            		return(msg);
	            	}

	            	// Pop stack and get top character 
	            	// if (!opening_brackets_stack.isEmpty()) {
	            		top = opening_brackets_stack.pop();
	            	// }
            	
            		// char topType = top.getType();            	
            	                    	
            		// Process closing bracket, write your code here
            		if (!top.Match(next)) {
            			
            			// Return location of unmatched closing bracket
                		position = position + 1;
                		msg = Integer.toString(position);
                		return(msg);
            		} 
            		
            		
            	} // end outer if
            
            } // end else
            
        } // end for
        
        		
        // If empty stack, all matched
		if (opening_brackets_stack.isEmpty()) {
			
			// Return success
			return(msg); 
		
		// Stack contains unmatched characters	
		} else {
		  
			// Return location of first unmatched opening bracket
			while (!opening_brackets_stack.isEmpty()) {
				top = opening_brackets_stack.pop();
			}
			
			// 1 based index of first unmatched opening bracket
			int pos = top.getPosition() + 1;
			
			msg = Integer.toString(pos); 
			return(msg);
			
		} // end else
        
    }  // end myMain()
    
    
} // end class check_brackets()
