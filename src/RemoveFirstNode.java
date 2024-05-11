public class RemoveFirstNode {
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

        //second element removal
        list.removeFirst();
        list.display();

        //third element removal
        list.removeFirst();
        list.display();

        //empty list
        list.removeFirst();
        list.display();

        list.removeFirst();


    }
}















