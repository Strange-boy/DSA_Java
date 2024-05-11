

public class AddLastLinkedList {

    //in order to represent the structure of basic Node
    public static class Node {
        int data;
        Node next;
    }

    //in order to add the data to the linked list
    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int value){
            //we have to create a node
            Node temp = new Node();
            temp.data = value;
            temp.next = null;

            if(size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }

            size += 1;
        }
    }

    public static void testList(LinkedList list){
        for(Node temp = list.head; temp != null; temp = temp.next){
            System.out.println(temp.data);
        }

        System.out.println("List size: " + list.size);
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);

        testList(list);
    }
}
