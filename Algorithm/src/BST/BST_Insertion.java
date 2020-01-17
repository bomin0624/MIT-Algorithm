
public class BST_Insertion {

    class Node { 
        int key; 
        Node left, right; 
  
        public Node(int item) { 
            key = item; 
            left = right = null; 
        } 
    } 
  
    // Root of BST 
    Node root; 
  
    // Constructor 
    BST_Insertion() {  
        root = null;  
    } 
  
    void insert(int key) { 
       root = insertRec(root, key); 
    } 
      
    Node insertRec(Node root, int key) { 
    	
    	
        /* If the tree is empty, return a new node */
        if (root == null) { 
            root = new Node(key); 
            return root; 
        } 
        
        //Compare to the node go left or right do the recursion until the tree is empty
        
        if (key < root.key) 
            root.left = insertRec(root.left, key); 
        else if (key > root.key) 
            root.right = insertRec(root.right, key); 
  
        /* return the unchanged node pointer */
        return root; 
    } 
  
    // Cannot make static reference to non-static fields
    void inorder()  { 
       inorderRec(root); 
    } 
  
    // A utility function to do inorder traversal of BST 
    void inorderRec(Node root) { 
        if (root != null) { 
            inorderRec(root.left); 
            System.out.println(root.key); 
            inorderRec(root.right); 
        } 
    } 
  

    public static void main(String[] args) { 
    	BST_Insertion tree = new BST_Insertion(); 
  
        /* 
              50 
           /     \ 
          30      70 
         /  \    /  \ 
       20   40  60   80 */
        tree.insert(50); 
        tree.insert(30); 
        tree.insert(20); 
        tree.insert(40); 
        tree.insert(70); 
        tree.insert(60); 
        tree.insert(80); 
  
        tree.inorder(); 
    } 
}
