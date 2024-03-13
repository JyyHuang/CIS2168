package ClassFiles;
/* Builds a toy sequential tree of integers and prints it sideways.
   Example: ToyIntTree(7) is this complete tree, printed sideways:
          7
     3
          6
1
          5
     2
          4
*/

public class ToyIntTree {
   private Node root;

   private class Node {
      int data;           // value stored at this node
      Node left, right;   // left and right subtrees of this node

      public Node(int data) { this(data, null, null); }

      public Node(int data, Node left, Node right) {
         this.data = data;
         this.left = left;
         this.right = right;
      }
   }

   /* Constructor: builds a sequential tree with given number of nodes */
   public ToyIntTree(int max) {
       this.root = buildTree(1, max);
   } // YOUR CODE HERE

   /* Other methods to implement, as explained in class */
   private Node buildTree(int n, int max) {
       if (n > max) return null;
       return new Node(n, buildTree(2*n, max), buildTree(2*n+1, max)); 
   } // YOUR CODE HERE

   public void printSideways() {
       printSideways(root, 0);
   } // YOUR CODE HERE

   private void printSideways(Node root, int level) {
       if(root != null){
           printSideways(root.right, level + 1);
           for (int i = 0; i < level; i++) {
                System.out.print("     ");
           }
           System.err.println(root.data + " ");
           printSideways(root.left, level + 1);
       }
   }

   public static void main(String[] args) {
      ToyIntTree bt = new ToyIntTree(7);
      bt.printSideways();
   }
}
