
/**
 * AVL tree implementation.  Extends BST class, overriding insertions.
 * 
 * @author jefcha
 */
public class AVLTree extends BST
{

	/**
	 * Constructor.
	 */
	public AVLTree() {
        super();
	}


	/**
     * Add key to tree.
     * 
     * @param key Key to add to tree.
     */
	@Override
	public void insert(int key) {
		mRoot = insert(mRoot, key);
	}
	

    /**
     * Recursive method to add key to tree.  Will perform necessary rotations to rebalance tree after insertion.
     * 
     * @param root Root node of tree to add 'key'.
     * @param key Key to add to tree.
     * @return Update root node.
     */
	@Override 
	protected Node insert(Node root, int key) {
		// check if root is empty
		if (root == null) {
			root = new Node(key);
		}
		//IMPLEMENTED BY ME
        else if (key < root.mKey) {
            // inserts the new node into left subtree
        	root.mLeftChild = insert(root.mLeftChild, key);
        	
        	//check balance factor (if it is greater than equal to 2 
        	//then the tree need rebalancing)
        	if (balanceFactor(root)>=2)
        		
        		//If the key is less than the key of the left child
        		if (key < root.mLeftChild.mKey)

        			//A right rotation is performed on the root
        			root = rightRotation(root);
        		else
        			//Otherwise a left-right rotation is performed on the root
        			root = leftRightRotation(root);

		}
		//IMPLEMENTED BY LECTURER
		else if (key > root.mKey) {
            // insert into right subtree
			root.mRightChild = insert(root.mRightChild, key);

			// check balance factor
            if (balanceFactor(root) <= -2)
                if (key > root.mRightChild.mKey) {
                    root = leftRotation(root);
                }
                else {
            		root = rightLeftRotation(root);
                }
		}
		else {
			// duplicate value, we do not insert into tree
		}

		
        return root;
	} // end of insert()
	
	
	/**
	 * Compute the balance factor.
	 * 
	 * @param node Node we like to compute balance factor for.
	 * @return Balance factor of node.
	 */
	public int balanceFactor(Node node) {
		return height(node.mLeftChild) - height(node.mRightChild);
	} // end of balanceFactor


    /**
     * Perform right rotation between root and its leftChild.
     * 
     * @param root Root of tree to perform rotations on.
     * @return new root of rotation tree.
     */
    protected Node rightRotation (Node root)
    {
    	//***IMPLEMENTED BY MYSELF***//
    	//A new temp node is created to store the left chid
    	Node child = root.mLeftChild;
    	
    	//the left child is then replaced with the right right child
    	root.mLeftChild = child.mRightChild;
    	
    	//the right child is then replaced with the root
    	child.mRightChild = root;
    	
    	//The child is then passed back as the new root
        return child;
    } // end of rightRotation()

    
    /**
     * Perform left rotation between root and its right child.
     * 
     * @param root Root of tree to perform rotation on.
     * @return new root of rotation tree.
     */
    protected Node leftRotation (Node root)
    {
    	//***IMPLEMENTED BY LECTURER
        Node child = root.mRightChild;
        root.mRightChild = child.mLeftChild;
        child.mLeftChild = root;

        return child;
    } // end of leftRotation()

    
    /**
     * Perform left-right rotation.
     * 
     * @param root Root of tree to perform rotations on.
     * @return new root of rotation tree.
     */
    protected Node leftRightRotation (Node root)
    {
    	//IMPLEMENTED BY LECTURER
    	root.mLeftChild = leftRotation(root.mLeftChild);

        return rightRotation(root);
    } // end of leftRightRotation()


    /**
     * Perform right-left rotation.
     * 
     * @param root Root of tree to perform rotations on.
     * @return new root of rotation tree.
     */
    protected Node rightLeftRotation (Node root)
    {
    	//IMPLEMENTED BY ME
    	//A right rotation is performed on the right child and this becomes the
    	//new right child
        root.mRightChild = rightRotation(root.mRightChild);
        
        //A left rotation is then perfomed on the root, and passed back as the new root
        return leftRotation(root);
    } // end of rightLeftRotation()


} // end of class AVLTree
