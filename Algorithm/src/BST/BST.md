# Binary Search Tree Insertion 

###### tags: `Leetcode` `easy` 

### Cannot make static reference to non-static fields

    void inorder()  { 
       inorderRec(root); 
    } 
    
    void inorderRec(Node root) { 
        if (root != null) { 
            inorderRec(root.left); 
            System.out.println(root.key); 
            inorderRec(root.right); 
        } 
    } 
  

    public static void main(String[] args) { 
    	
        BST_Insertion tree = new BST_Insertion(); 
   
            tree.insert(50); 
            tree.insert(30); 
            tree.insert(20); 
            tree.insert(40); 
            tree.insert(70); 
            tree.insert(60); 
            tree.insert(80); 
  
            tree.inorder(); 
    } 

## Instance Methods vs Static Methods in Java

1.The instance method requires the object of its class to be created before it can be called. <font color="#357EC7">Static methods in Java can be called without creating the object of the class.</font>

2.Java static method is declared using static keyword. An instance method does not need any keyword.

3.The static method has a single copy for a class. But instance methods have multiple copies depending on the number of instances created for that particular class.

4.We can invoke a static method by using its class reference. An instance method is invoked by using the object reference.

5.<font color="#357EC7">We can’t access instance methods and instance variables with the help of Static methods in Java.</font> We can access static variables and static methods with the help of the Instance method.

## Static Methods in Java

Static methods in Java belong to classes, unlike other classes it doesn’t belong to the instance of the class. This method can be accessible to every instance but the methods defined in the instance are only accessed by that member of the class. It can access only static data.


1. These are declared with the keyword “static” when defining a method
2. This method belongs to the class and not to the object.
3. It can access only static data. It can not access instance variables.
4. A static method can call only static methods, non-static methods are not called by a static method.
5. This method is can be accessed by the class name it doesn’t need any object.

## Why use Recursion?
Benefit: Easy to Read
Disadvantage: Stack Overflow 

## Iterative

More Efficient,can avoid Stack Overflow

[Insert Node in a BInary Search Tree](https://algorithm.yuanbin.me/zh-tw/binary_search_tree/insert_node_in_a_binary_search_tree.html)
```
//psceudo code

public class Insert_Node(Node root,key){

if (root == null){
        root = new Node(key);
        return root;    
}

Node rootcopy = root

while (root != null){
    if (node.key > root.key && node.right == null){
    node.right = node;
    break;
}
    else if (node.key < root.key && node.left == null){
    node.left = node;
    break;
}

    else if (node.key>root.key){
        root = root.right;
}
    else (node.key<root.key){
        root = root.left;
}
    return rootcopy;
}
```

## Constructor in Java
[Constructor in Java – Master all the Concepts in One Shot!](https://data-flair.training/blogs/constructor-in-java/)

Constructor in Java is an object builder or a block of code which creates an object. It is very similar to a Java method the main difference is that it does not have a return type, not even void. It is often referred to as a method. Constructor invoked automatically when an object is created.

<font color="#A9A9A9">Note – When an object is created at least one constructor is called. If there is no constructor then the default constructor is called.</font>



