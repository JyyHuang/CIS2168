package ClassFiles.Febnine;

import java.util.NoSuchElementException;
import java.util.concurrent.RecursiveTask;

public class SLListSimple<E> {
   private int n;        // size of the list
   private Node first;   // reference to the first node of the list

   // Private helper Node data type
   private class Node {
      E data;
      Node next;

      // constructor: initializes data to the value e and
      // initializes the next Node reference to null
      Node(E e) { this(e, null); }

      // constructor: initializes data to the value e and
      // initializes the next Node reference to node
      Node(E e, Node node) {
         data = e;
         next = node;
      }
   }

   // constructor: initializes an empty list
   public SLListSimple() { n = 0; } // fist = last = null by default

   // adds an element to the front of the list
   public void addFirst(E value) {
      // YOUR CODE HERE
      
   }

   // adds element to the end of the list
   public void addLast(E value) {
      // YOUR CODE HERE
   }

   // removes and returns the first element from the list
   public E removeFirst() {
      // YOUR CODE HERE
      return null; // CHANGE THIS LINE
   }

   // removes and returns the last element from the list
   public E removeLast() {
      // YOUR CODE HERE
      return null; // CHANGE THIS LINE
   }


   // is this list empty?
   public boolean isEmpty() {return n == 0;}

   // the size of this list (the number of nodes in it)
   public int size() { return n; }

   // returns a string representation of this list
   public String toString() {
      StringBuilder s = new StringBuilder();
      if (isEmpty()) return "This list is empty ";
      Node current = first;
      while (current != null) {
         s.append(current.data + " ");
         current = current.next;
      }
      return s.toString();
   }

   public static void main(String[] args) {

      SLListSimple<String> list = new SLListSimple<>();
      In in = new In("src/ClassFiles/Febnine/franklin1.txt");
      while (!in.isEmpty()) {
         list.addLast(in.readString());
      }

      System.out.println(list);
      System.out.println("   removing the last item, \"" + list.removeLast() + "\":");
      System.out.println(list);

      System.out.println();
      System.out.println("   removing the first item, \"" + list.removeFirst() + "\":" );
      System.out.println(list);

      System.out.println("--------------");
      //System.out.println(list.indexOf("sep"));
   }

}
