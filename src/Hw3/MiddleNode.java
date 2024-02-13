package Hw3;

public class MiddleNode {
    /* Tortoise and Hare algorithm
     *
     * Initialize two pointers: one fast, one slow
     * Meaning the fast pointer moves by two nodes, and the slow pointer moves by one node
     * once the fast pointer gets to the end, then we are guaranteed that the slow pointer is the middle value
    */

    public static Node getMiddle(Node list){
        Node fast = list;
        Node slow = list;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node<Integer> one = new Node<Integer>(1);
        Node<Integer> two = new Node<Integer>(2, one);
        Node<Integer> five = new Node<Integer>(5, two);
        Node<Integer> four = new Node<Integer>(4, five);
        Node<Integer> three = new Node<Integer>(3, four);

        System.out.println(getMiddle(three).data); // should print 5
    }
}
