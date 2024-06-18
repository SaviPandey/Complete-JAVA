public class ReverseLL {
    public static class Node {
        int data ;
        Node next ;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public void printLL(){
        if(size == 0){
            System.out.println("Empty");
            return;
        } 
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void reverseLL(){
        Node prev = null;
        Node curr = tail = head; //bcoz after reversing the tail will be same as head
        Node next;

        while( curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev ;  //after loop the curr will be at null and prev will be at tail position
    }
    public static void main(String args[]){
        ReverseLL rev = new ReverseLL();
        rev.addLast(1);
        rev.addLast(2);
        rev.addLast(3);
        rev.addLast(4);

        rev.printLL();
        rev.reverseLL();
        rev.printLL();
    }
}
