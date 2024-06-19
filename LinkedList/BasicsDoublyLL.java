public class BasicsDoublyLL {
    public static class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
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
        head.prev = newNode;
        head = newNode;
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }
    public void removeFirst(){
        if(head == null){
            System.out.println("List is empty");
            return;
        } else if(head.next == null){
            head = tail = null;
            size = 0;
            return;
        }
        head = head.next;
        head.prev = null;
        size--;
    }
    public void removeLast(){
        if(head == null){
            System.out.println("List is empty");
            return;
        } else if(head.next == null){
            head = tail = null;
            size--;
            return;
        } else{
            tail = tail.prev;
            tail.next = null;
            size--;

        }
    }
    public void printLL(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String args[]){
        BasicsDoublyLL b = new BasicsDoublyLL();
        b.addFirst(1);
        b.addFirst(2);
        b.addFirst(3);
        b.addFirst(4);
        //4<->3<->2<->1
        b.printLL();
        System.out.println(size);

        b.removeFirst();
        b.printLL();
        System.out.println(size);

        b.addLast(0);
        b.printLL();
        System.out.println(size);

        b.removeLast();
        b.printLL();
        System.out.println(size);

    }
}
