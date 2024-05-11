public class AddFirstInList {
    public static class Node{
        int data;
        Node next;
    }

    //in order to represent the linked list
    public static class LinkedList{
        Node head;
        Node tail;
        int size;

        //in order to add the node to the last of the list
        public void addLast(int value){
            Node temp = new Node();
            temp.data = value;
            temp.next = null;

            if(size == 0){
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }

            size += 1;
        }

        //in order to add first in linked list
        public void addFirst(int value){
            //we have to create a node
            Node temp = new Node();
            temp.data = value;
            temp.next = null;

            if(size == 0){
                head = tail = temp;
            } else {
                temp.next = head;
                head = temp;
            }

            size += 1;
        }

        //in order to display all the elements in the list
        public void display(){
            for(Node temp = head; temp != null; temp = temp.next){
                System.out.println(temp.data);
            }

            System.out.println("Size: " + size);
        }


    }

    //main function
    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addFirst(7);

        System.out.println("The Elements in the list:");
        list.display();

        list.addLast(95);
        list.addFirst(79);
        System.out.println("The Elements in the list:");
        list.display();
    }
}
