package Hw3;

public class RemoveDups {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;
        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList deDup(LinkedList first) {
        // Write your code here.
        LinkedList curr = first;
        while (curr.next != null && curr != null){
            if (curr.value == curr.next.value){
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return first;
    }

    public static void main(String[] args) {
        RemoveDups removeDups = new RemoveDups();

        LinkedList first = new LinkedList(1);
        first.next = new LinkedList(1); first.next.next = new LinkedList(3);
        first.next.next.next = new LinkedList(4); first.next.next.next.next = new LinkedList(4);
        first.next.next.next.next.next = new LinkedList(4); first.next.next.next.next.next.next = new LinkedList(5);
        first.next.next.next.next.next.next.next = new LinkedList(6); first.next.next.next.next.next.next.next.next = new LinkedList(6);
        
        System.out.println("Original linked list: ");
        printList(first);
        LinkedList deDupedList = removeDups.deDup(first);
        System.out.println("Deduped List: ");
        printList(deDupedList);

    }

    public static void printList(LinkedList list){
        while (list != null) {
            System.out.print(list.value + " -> ");
            list = list.next;
        }
        System.out.println("null");
    }

}
