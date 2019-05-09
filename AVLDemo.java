import java.io.DataInputStream;
import java.util.Scanner;


/**
 * Process and demonstrate AVL tree.
 * 
 * @author jefcha
 */
public class AVLDemo
{

	/** 
	 * Print out help menu.
	 */
	public static void printHelp()
	{
	    System.err.println("Available commands:\n"
	    		+ "    insert <number>\n"
	    		+ "    height\n"
	    		+ "    print_ascii\n"
	    		+ "    quit|end\n"
	    		);
	} 
	
	
	/** 
	 * Get next command/operation from file.
	 */ 
	public static void processOperations(BST tree)
	{
	    Scanner is = new Scanner(System.in);
		
	    while( is.hasNext() ) {
	        String command = is.next();
	        
            if( command.compareTo("insert") == 0 ) {
            	if (is.hasNextInt()) {
            		int key = is.nextInt();
            		tree.insert(key);
            	}
            }
            else if( command.compareTo("height") == 0  ) {
            	int height = tree.height();
            	System.out.println("Height = " + height);
            }
            else if( command.compareTo("print_ascii") == 0  ) {
                tree.asciiPrint();
            }
            else if( command.compareTo("quit") == 0 || command.compareTo("end") == 0 ) {
            	break;
            }
	        else
	        {
	        	
	        	System.err.println("Did not recognize command " + command + ". Enter valid command.");
                printHelp();
	        }
	    }
	} /* end of processOperations() */	
	
	
	
	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		
		processOperations(tree);
	} // end of main()
	
} // end of class AVLDemo