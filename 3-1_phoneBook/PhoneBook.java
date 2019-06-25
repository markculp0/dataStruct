import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Comparator;
import java.util.Collections;

public class PhoneBook {

    private FastScanner in = new FastScanner();
    // Keep list of all existing (i.e. not deleted yet) contacts.
    private List<Contact> contacts = new ArrayList<>();

    
    Comparator<Contact> c = new Comparator<Contact>() {
        public int compare(Contact u1, Contact u2) {
          return u1.getNum().compareTo(u2.getNum());
        }
     };

    public static void main(String[] args) {
        new PhoneBook().processQueries();
    }

    private Query readQuery() {
        String type = in.next();
        int number = in.nextInt();
        if (type.equals("add")) {
            String name = in.next();
            return new Query(type, name, number);
        } else {
            return new Query(type, number);
        }
    }

    private void writeResponse(String response) {
        System.out.println(response);
    }
    

    /* -------------------------------
     *	Original processQuery function
     * -------------------------------
    private void processQuery(Query query) {
        if (query.type.equals("add")) {
            // if we already have contact with such number,
            // we should rewrite contact's name
            boolean wasFound = false;
            for (Contact contact : contacts)
                if (contact.number == query.number) {
                    contact.name = query.name;
                    wasFound = true;
                    break;
                }
            // otherwise, just add it
            if (!wasFound)
                contacts.add(new Contact(query.name, query.number));
        } else if (query.type.equals("del")) {
            for (Iterator<Contact> it = contacts.iterator(); it.hasNext(); )
                if (it.next().number == query.number) {
                    it.remove();
                    break;
                }
        } else {
            String response = "not found";
            for (Contact contact: contacts)
                if (contact.number == query.number) {
                    response = contact.name;
                    break;
                }
            writeResponse(response);
        }
    } // end old processQuery
    */

    
    /* -------------------------
     * New processQuery function 
     * -------------------------
    */ 
    private void processQuery2(Query query) {
        if (query.type.equals("add")) {
            // if we already have contact with such number,
            // we should rewrite contact's name
        	
                    
        	// Check if empty
        	if (contacts.isEmpty()) 
        		contacts.add(new Contact(query.name, query.number));
        	
        	// Check if new number greater than last one
        	else if (contacts.get(contacts.size() - 1).number < query.number) {
        		contacts.add(new Contact(query.name, query.number));
        	} else {
        		    
                for(int i = 0; i < contacts.size(); i++) {
                	// Replace it
                	if (contacts.get(i).number == query.number) {
            			contacts.get(i).name = query.name;
            			break;
            		// Insert it
                	} else if (contacts.get(i).number > query.number) {
                		contacts.add(i, new Contact(query.name, query.number));
                		break;
                	// If reach end, append it
                	} else if (i == contacts.size() - 1) {
        			contacts.add(new Contact(query.name, query.number));
                	}
                                	
                } // end for
                
        	}  // end else
        	        	        	        	
            
        // Delete number
        } else if (query.type.equals("del")) {
        	      	        	        	
        	int index = Collections.binarySearch(contacts, new Contact("", query.number), c );
        	
        	// Return match
            if (index > -1) {            	
            	contacts.remove(index);            	
            }
        	
        // Find number
        } else {
        	
        	String response = "not found";
        	        	        	
        	int index = Collections.binarySearch(contacts, new Contact("", query.number), c );
        	
        	// Return match
            if (index > -1) {
            	response = contacts.get(index).name;
            }        	
                        
            writeResponse(response);
        }
    } // end processQuery2
    

    public void processQueries() {
        int queryCount = in.nextInt();
        for (int i = 0; i < queryCount; ++i)
            processQuery2(readQuery());
    }

    static class Contact {
        String name;
        int number;

        public Contact(String name, int number) {
            this.name = name;
            this.number = number;
        }
        
        Integer getNum() {
        	return this.number;
        }
    }

    static class Query {
        String type;
        String name;
        int number;

        public Query(String type, String name, int number) {
            this.type = type;
            this.name = name;
            this.number = number;
        }

        public Query(String type, int number) {
            this.type = type;
            this.number = number;
        }
        
        Integer getNum() {
        	return this.number;
        }
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
