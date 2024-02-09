package ClassFiles;

public class NodeTest {
   public static void main(String[] args) {
      // TODO: 1) create and initialize nodes with values 5, 1, and 2.

      Node<Integer> one = new Node<>(1); 
      Node<Integer> two = new Node<>(2);
      Node<Integer> five = new Node<>(5);

      // TODO: 2) link the nodes to create the list [2, 1, 5]
      two.next = one;
      two.next.next = five;

      // TODO: 3) Iterate through the list and print 2 -> 1 -> 5 -> null
      Node<Integer> dummy = two;
      while (dummy != null){
         System.out.print(dummy.data + " -> ");
         dummy = dummy.next;
      }
      System.out.print("null");

   }
}
