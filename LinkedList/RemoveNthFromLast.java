public class RemoveNthFromLast {
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

    public void deleteNthFromLast(int n){
        //Calculate Size
        int sz = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;;
        }
        //Check if head is the element to delete
        if(n == sz){
            head = head.next; // Delete First
            return;
        }
        
        Node prev = head;
        int i = 1;
        int iToFind = sz - n;
        while(i < iToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;   
        return;
    }

    public static void main(String args[]){
        RemoveNthFromLast r = new RemoveNthFromLast();
        r.addLast(1);
        r.addLast(2);
        r.addLast(3);
        r.addLast(4);
        r.printLL();

        //n -> nth element from last
        r.deleteNthFromLast(4);
        r.printLL();
    }

}
