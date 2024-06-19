public class ZigZag {
    public static class Node {
        int data ;
        Node next ;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
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
    public void zigZag(){
        //findMid
        Node slow = head;
        Node fast = head.next; //Mid -> 1st half's last node
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        //Reverse 2nd Half
        Node prev = null;
        Node curr = mid.next;
        mid.next = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node leftHead = head;
        Node rightHead = prev;
        Node nextLeft, nextRight;
        
        //Alternate merging
        while(leftHead != null && rightHead != null){
            //Zig-Zag
            nextLeft = leftHead.next;
            leftHead.next = rightHead;
            nextRight = rightHead.next;
            rightHead.next = nextLeft;
            
            //Update the head's
            leftHead = nextLeft;
            rightHead = nextRight;
        }
    }
    public static void main(String args[]){
        ZigZag z = new ZigZag();
        z.addFirst(1);
        z.addFirst(2);
        z.addFirst(3);
        z.addFirst(4);
        z.addFirst(5);
        z.printLL();

        z.zigZag();
        z.printLL();
    }
}
