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

    char type;
    int position;
}

class check_brackets {
  
    public static void main(String[] args) throws IOException {
      
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
            	
                // Process opening bracket
            	Bracket brkt = new Bracket(next, position);
                opening_brackets_stack.push(brkt);
            } // end if

            if (next == ')' || next == ']' || next == '}') {
            	
                // Process closing bracket, write your code here
            } // end if
            
        } // end for

        // Printing answer, write your code here
        
        
    }  // end main()
} // end class check_brackets()
