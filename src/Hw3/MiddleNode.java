package Hw3;

public class MiddleNode {
    Node first; // reference to the first node
    int size; // the number of items on this list
    
    /* Class Node: stores data and a link to another Node */
    class Node {
        private Object data;
        private Node next;
    }

    /* adds an item to the front of the list */
    void add(Object item) {
        Node oldfirst = first;
        first = new Node();
        first.data = item;
        first.next = oldfirst;
        size++;
    }

    /* Tortoise and Hare algorithm
     *
     * Initialize two pointers: one fast, one slow
     * Meaning the fast pointer moves by two nodes, and the slow pointer moves by one node
     * once the fast pointer gets to the end, then we are guaranteed that the slow pointer is the middle value
    */
    public Node getMiddle(){
        Node fast = first;
        Node slow = first;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        MiddleNode list = new MiddleNode();
        list.add(8); list.add(6); list.add(1); list.add(2); list.add(99); list.add(10);
        for (Node x = list.first; x != null; x = x.next){
            System.out.print(x.data + " -> ");
        }
        System.out.println("null");
        Node mid = list.getMiddle();
        System.out.println("middle node: " + mid.data);
    }
}
