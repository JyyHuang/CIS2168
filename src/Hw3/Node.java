package Hw3;

// Generic Node data type
class Node<E> {
   E data;
   Node<E> next;

   
   Node(E data){
      this(data, null);
   }

   Node(E data, Node<E> next){
      this.data = data;
      this.next = next;
   }
}
