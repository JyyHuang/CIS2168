package ClassFiles;

import java.util.*;

public class ResizingArrayList<E> implements Iterable<E> {
   // the initial capacity of the underlying resizing array
   private static final int INIT_CAPACITY = 10;

   private E[] elements;   // the underlying array of generic elements
   private int n;          // the number of elements in the list

   /* Constructor: Initializes an empty list. */
   @SuppressWarnings("unchecked")
   public ResizingArrayList() {
      elements = (E[]) new Object[INIT_CAPACITY];
      n = 0;
   } 

   // Returns the number of elements in the list.
   public int size() { return n; }

   // Is this list empty?
   public boolean isEmpty() { return n == 0;}

   // Resizes the underlying array holding the elements
   private void resize(int capacity) {
      assert capacity >= n;
      elements = Arrays.copyOf(elements, capacity);
   }

   // Adds the item to the end of this list.
   public void add(E element) {  
      if (n == elements.length){
         resize(2 * elements.length);
      }
      elements[n++] = element;
   }

   // Adds the element at index.
   public void add(int index, E element) {
      if (index < 0 || index >= n){
         throw new ArrayIndexOutOfBoundsException();
      }
      if (n == elements.length){
         resize(2 * elements.length);
      }
      for (int i = n; i > index; i--){
         elements[i] = elements[i-1];
      }
      elements[index] = element;
      n++;
   } 

   // Replaces the element at index with the given element
   public void set(int index, E element) {
      if (index < 0 || index >= n){
         throw new ArrayIndexOutOfBoundsException();
      }
      elements[index] = element;
   }

   // Returns the item at index without removing it
   public E get(int index) { 
      if (index < 0 || index >= n){
         throw new ArrayIndexOutOfBoundsException();
      }
      return elements[index]; 
   }

   // Removes the element at position index
   public void remove(int index) {
      if (index < 0 || index >= n){
         throw new ArrayIndexOutOfBoundsException();
      }
      for (int i = index + 1; i < n; i++){
         elements[i - 1] = elements[i];
      }
      n--;
   }

   // Returns the index of the first occurrence of element or -1 if not found
   public int indexOf(E element) {
      for (int i = 0; i < n; i++){
         if (elements[i] == element){
            return i;
         }
      }
      return -1;
   }

   @Override
   // Returns an iterator that iterates over the items in this list
   public Iterator<E> iterator() {return new ArrayIterator();}
   // an iterator, doesn't implement remove() since it's optional
   private class ArrayIterator implements Iterator<E> {
      private int i = 0;
      public boolean hasNext()  { return i < n;                               }
      public void remove()      { throw new UnsupportedOperationException();  }

      public E next() {
         if (!hasNext()) throw new NoSuchElementException();
         return elements[i++];
      }
   }

   @Override
   // returns a string representation of this list
   public String toString() {
      StringBuilder s = new StringBuilder("[ ");
      if (n == 0) return "This list is empty";
      for (E value : this)
         s.append( value + " ");
      s.append("]");
      return s.toString();
   }

   public static void main(String[] args) {
      ResizingArrayList<String> list = new ResizingArrayList<>();
      System.out.println(list.isEmpty());
      list.add("to"); list.add("be"); list.add("or"); list.add("not"); list.add("to"); list.add("be");
      for (String s : list)
         System.out.print(s + " ");
      System.out.println();   // to be or not to be
      System.out.println(list);
      list.remove(3); // remove the element at index 3
      System.out.println(list);
      list.add(2, "awesome"); // add an element at index 2
      System.out.println(list);
      list.add(0, "Or");    // add an element at the beginning
      list.add(3, "really"); // add an element at index 2
      list.add("great"); // and an element at the end
      System.out.println(list);
      list.set(list.size() - 1, "good");  // set the last element
      System.out.println(list);
      list.set(7, "do");
      System.out.println(list);
   }
}
