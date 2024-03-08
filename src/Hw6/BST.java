package Hw6;

import java.util.LinkedList;
import java.util.Queue;

public class BST<Key extends Comparable> {
   private Node root;
   private class Node  {
      Key key;           // this node's data
      Node left, right;  // this node's children

      // Constructor: initializes data and makes this a leaf node
      public Node(Key key) { this(key, null, null); }

      // Constructor: initializes node data and sets its subtrees
      public Node(Key key, Node left, Node right) {
         this.key   = key;
         this.left  = left;
         this.right = right;
      }
   }
   // Constructor: initializes an empty binary search tree
   public BST() { }

   // inserts a new node in the binary search tree (BST)
   public void add (Key key ) { root = add(root, key); }

   // recursively adds a new node preserving the BST property
   private Node add (Node node, Key key) {
      if (node == null) return new Node(key);
      int cmp = key.compareTo(node.key);
      if (cmp <= 0) node.left  = add(node.left, key);
      else          node.right = add(node.right, key);
      return node;
   }
   // contains method
   public Node contains(Key key){
       return containsHelper(root, key);
   }

   private Node containsHelper(Node root,Key key){
      if (root == null){
         return null;
      } 
      int cmp = key.compareTo(root.key);
      if (cmp == 0) return root;
      if (cmp < 0) return containsHelper(root.left, key);       
      else return containsHelper(root.right, key);       
   }

   // begin inorder traversal
   public void inorderTraversal() {
      inorderHelper(root);
   }

   // perform inorder traversal recursively
   private void inorderHelper( Node node ) {
      if ( node == null )  return;
      inorderHelper( node.left );           // traverse left subtree
      System.out.printf( "%s ", node.key ); // output node data
      inorderHelper( node.right );          // traverse left subtree
   }

   // begin preorder traversal
   public void preorderTraversal() {
      preorderHelper(root);
   }

   // perform preorder traversal recursively
   private void preorderHelper( Node node ) {
      if ( node == null )  return;
      System.out.printf( "%s ", node.key ); // output node data
      preorderHelper( node.left );           // traverse left subtree
      preorderHelper( node.right );          // traverse left subtree
   }

   // begin postorder traversal
   public void postorderTraversal() {
      postorderHelper(root);
   }

   // perform postorder traversal recursively
   private void postorderHelper( Node node ) {
      if ( node == null )  return;
      postorderHelper( node.left );           // traverse left subtree
      postorderHelper( node.right );          // traverse left subtree
      System.out.printf( "%s ", node.key ); // output node data
   }

   public void bfs(){
       bfsHelper(root);
   }

   private void bfsHelper(Node root){
       Queue<Node> queue = new LinkedList<>();
       queue.add(root);

       while (!queue.isEmpty()) {
           Node next = queue.remove();
           System.out.print(next.key + " ");
           if (next.left != null) queue.add(next.left);
           if (next.right != null) queue.add(next.right);
       }
   }

   // BST client: outputs a sequence of integers in sorted order:
   public static void main(String[] args) {
      BST<Integer> bst = new BST<>();
      Integer[] keys = {21, 68, 11, 13, 17, 97};
      System.out.println("Building a BST from the following keys:");
      for (Integer key : keys) {
         System.out.printf("%d ", key);
         bst.add(key);
      }

      System.out.printf("%n%nKeys in sorted order:%n");
      bst.inorderTraversal(); // prints 11 13 17 21 68 97
      System.out.println();
      System.out.println("Preorder: ");
      bst.preorderTraversal();
      System.out.println();
      System.out.println("Postorder: ");
      bst.postorderTraversal();
      System.out.println();
      System.out.println(bst.contains(68));
   }
}
