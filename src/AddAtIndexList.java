public class AddAtIndexList {
    //in order to create the node
    public static class Node{
        int data;
        Node next;
    }

    //in order to declare our own linked list class
    public static class LinkedList{
        Node head;
        Node tail;
        int size;

        public void addLast(int value){
            //create the node
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

        //add the element at first
        public void addFirst(int value){
            //create the node
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

        //add at any index
        public void addAt(int idx, int value){
            if(idx < 0 || idx >= size){
                System.out.println("Invalid index");
            } else if(idx == 0){
                addFirst(value);
            } else if(idx == size - 1){
                addLast(value);
            } else {
                Node newNode = new Node();
                newNode.data = value;

                //temp node for iteration
                Node temp = head;

                for(int currIdx = 0; currIdx < idx - 1; currIdx += 1){
                    temp = temp.next;
                }

                //now in order to connect the new node
                newNode.next = temp.next;
                temp.next = newNode;

                size += 1;
            }
        }

        //in order to display the entire list
        public void showElements(){
            System.out.println("The Elements in the list are: ");
            for(Node temp = head; temp != null; temp = temp.next){
                System.out.println(temp.data);
            }
        }
    }

    //main function
    public static void main(String[] args){
        LinkedList list = new LinkedList();

        list.addFirst(10);
        list.addLast(20);
        list.addAt(9, 90);
        list.addAt(1, 90);
        list.showElements();

        list.addFirst(30);
        list.addLast(100);
        list.addAt(2, 9);
        list.addAt(1, 8);
        list.showElements();
    }
}
