public class RemoveAtLinkedList {
    //in order to insert the node
    public static class Node{
        int data;
        Node next;
    }

    //in order to create a custom linked list class
    public static class LinkedList{
        Node head;
        Node tail;
        int size;

        //in order to add the node at last
        public void addLast(int value){
            //create a new node
            Node temp = new Node();
            temp.data = value;
            temp.next = null;

            if(size == 0){
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }

            //increase the size
            size += 1;
        }

        //in order to display all the node
        public void showElements(){
            System.out.println("In order to display all the elements:");
            for(Node temp = head; temp != null; temp = temp.next){
                System.out.println(temp.data);
            }
        }

        //in order to remove the first node
        public void removeFirst(){
            //if the list is empty
            if(size == 0){
                System.out.println("List is empty");
            } else if(size == 1){
                head = tail = null;
                size -= 1;
            } else{
                head = head.next;
                size -= 1;
            }
        }

        //in order to remove the last node
        public void removeLast(){
            if(size == 0){
                System.out.println("List is empty");
            } else if(size == 1){
                head = tail = null;
                size -= 1;
            } else {
                Node temp = head;
                for(int idx = 0; idx < size - 2; idx += 1){
                    temp = temp.next;
                }

                temp.next = null;
                tail = temp;
                size -= 1;
            }
        }

        //in order to remove at any index
        public void removeAt(int shIdx){
            if(shIdx < 0 || shIdx >= size){
                System.out.println("Invalid arguments");
            } else if(shIdx == 0){
                removeFirst();
            } else if(shIdx == size - 1){
                removeLast();
            } else {
                Node temp = head;

                for(int idx = 0; idx < shIdx - 1; idx += 1){
                    temp = temp.next;
                }

                temp.next = temp.next.next;
                size -= 1;
            }
        }

    }


    //main function where program execution starts
    public static void main(String[] args){
        LinkedList list = new LinkedList();

        list.addLast(10);
        list.addLast(30);
        list.addLast(20);
        list.addLast(35);
        list.addLast(100);

        //in order to display the elements
        list.showElements();

        //in order to remove elements
        list.removeAt(0);
        list.removeAt(5);
        list.removeAt(4);
        list.showElements();

        list.removeAt(2);
        list.showElements();


    }
}
