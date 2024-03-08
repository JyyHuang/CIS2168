package Hw6;

// BST client: outputs a sequence of integers in sorted order:
public class TestBST {
   public static void main(String[] args) {
       BST<Integer> tree = new BST<>();

       //Integer[] keys = {49, 28, 83, 18, 40, 71, 97, 11, 19, 32, 44, 69, 72, 92, 99};
       Integer[] keys = {28, 49, 18, 83, 40, 71, 97, 32, 19, 11, 44, 69, 72, 92, 99};

       System.out.println("Inserting the following keys: ");
       for (Integer key : keys) {
           System.out.printf("%d ", key);
           tree.add(key);           
       }
       System.out.printf("%n%nPreorder traversal%n");
       tree.preorderTraversal();

       System.out.printf("%n%nInorder traversal%n");
       tree.inorderTraversal();

       System.out.printf("%n%nPostorder traversal%n");
       tree.postorderTraversal();

       System.out.printf("%n%nBFS Traversal%n");
       tree.bfs();
      }
}
