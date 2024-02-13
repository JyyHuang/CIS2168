package Hw3;

public class ReverseLinkedList {
    /* Reversing a linked list
     *
     * Initialize prev node to null. Initialize current node.
     * Loop through the list
     * Update next node
     * Point current to prev
     * Update prev to current
     * Update current to next
     */

     public static Node reverseLinkedList(Node head){
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
     }
     public static void main(String[] args) {
        Node<Integer> one = new Node<Integer>(1);
        Node<Integer> two = new Node<Integer>(2, one);
        Node<Integer> five = new Node<Integer>(5, two);
        Node<Integer> four = new Node<Integer>(4, five);
        Node<Integer> three = new Node<Integer>(3, four);
        
        printList(three);
        reverseLinkedList(three);
        printList(one);
     }

    public static void printList(Node list){
        while (list != null) {
            System.out.print(list.data + " -> ");
            list = list.next;
        }
        System.out.println("null");
    }
}
