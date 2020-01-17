package BST;

public class BSTNode_Search {
	
    class Node { 
        int key; 
        Node left, right; 
  
        public Node(int item) { 
            key = item; 
            left = right = null; 
        } 
    } 
    
	public Node search(Node root, int key) 
	{ 
		
	    if (root==null || root.key==key) 
	        return root; 
	  
	    if (root.key > key) 
	        return search(root.left, key); 
	  
	    // value is less than root's key 
	    return search(root.right, key); 
	} 
}
