public class BasicsLL {
    public static class Node {
        int data;
        Node next;

        //contructor
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void addMiddle(int data , int index){   
        Node newNode = new Node(data);
        if(index == 0){
            addFirst(data);
            return;
        }
        size++;
        Node temp = head;
        int i = 0;
        while(i < index-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int deleteFirst(){
        if(size == 0){
            System.out.println("Already Empty");
            return Integer.MIN_VALUE;
        } else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int deleteLast(){
        if(size == 0){
            System.out.println("Already Empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = tail.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        // prev : i = size - 2
        for(int i = 0; i<size-2; i++){
            prev = prev.next;
        }
        int val = tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public void printLL() { // O(n)
        if(head == null){
            System.out.println("Linked List is Empty!");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String args[]){
        BasicsLL ll = new BasicsLL();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.addMiddle(3, 2);

        ll.printLL();
        // System.out.println(size);
        ll.deleteFirst();
        ll.printLL();

        ll.deleteLast();
        ll.printLL();
        // System.out.println(size);
    }
}
