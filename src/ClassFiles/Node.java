package ClassFiles;

// Generic Node data type
class Node<E> {
   E data;
   Node<E> next;

   // Would a constructor be useful in this small class?
   // (A constructor might initialize node data to the value e
   // and the next Node reference to null.)
   Node(E data){
      this(data, null);
   }

   Node(E data, Node<E> next){
      this.data = data;
      this.next = next;
   }
}
