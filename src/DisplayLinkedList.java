public class DisplayLinkedList {
    public static class Node{
        int data;
        Node next;
    }

    //in order to initialise a linked list
    public static class LinkedList{
        Node head;
        Node tail;
        int size;

        void addLast(int value){
            //we have to create a node
            Node temp = new Node();
            temp.data = value;
            temp.next = null;

            if(size == 0){
                //connect the list
                head = tail = temp;
            } else {
                //connect the node with previous node
                tail.next = temp;
                tail = temp;
            }

            size += 1;
        }

        int getSize(){
            return size;
        }

        void display(){
            Node temp;
            for(temp = head; temp != null; temp = temp.next){
                System.out.println(temp.data);
            }

            //in order to print the size
            System.out.println(size);
        }
    }

    public static void main(String[] args){
        LinkedList list = new LinkedList();

        //in order to add the elements
        list.addLast(10);
        list.addLast(20);
        list.addLast(70);
        list.addLast(40);

        //in order to find the size of the list
        System.out.println("List size: " + list.getSize());

        //in order to display the elements
        list.display();
    }
}
