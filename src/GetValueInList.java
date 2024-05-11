public class GetValueInList {

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

        //in order to display all the elements in the list
        public void display(){
            for(Node temp = head; temp != null; temp = temp.next){
                System.out.println(temp.data);
            }

            System.out.println("Size: " + size);
        }

        //in order to remove the first element
        public void removeFirst(){
            if(size == 0){
                System.out.println("List is empty");
            } else if(size == 1){
                head = tail = null;
                size = 0;
            } else {
                head = head.next;
                size -= 1;
            }
        }

        //in order to get the first element
        public int getFirst(){
            if(size == 0){
                System.out.println("The List is empty");
                return -1;
            } else {
                return head.data;
            }
        }

        //in order to get the last element
        public int getLast(){
            if(size == 0){
                System.out.println("The List is empty");
                return -1;
            } else {
                return tail.data;
            }
        }

        //in order to get the value at a particular index
        public int getValue(int reqIdx){
            if(size == 0){
                System.out.println("The List is empty");
                return -1;
            } else if(reqIdx < 0 || reqIdx >= size){
                System.out.println("Invalid index");
                return -1;
            } else {
                Node temp = head;
                for(int idx = 0; idx < reqIdx; idx += 1){
                    temp = temp.next;
                }

                return temp.data;
            }
        }
    }

    //main function
    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(60);
        list.addLast(70);

        //first element removal
        list.removeFirst();
        list.display();

        //get the first element
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.getValue(10));



        //second element removal
        list.removeFirst();
        list.display();
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.getValue(2));


        //third element removal
        list.removeFirst();
        list.display();

        //empty list
        list.removeFirst();
        list.display();
        System.out.println(list.getValue(0));


        list.removeFirst();
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.getValue(2));


    }
}
