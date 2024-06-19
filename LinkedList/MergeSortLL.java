public class MergeSortLL {
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

    public Node findMid(Node head){
        Node slow = head; 
        Node fast = head.next; //Because for Even-size list we want mid as last-node of left part
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        //Find Mid
        Node mid = findMid(head);
        Node rightHead = mid.next;
        mid.next = null;

        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        return merge(newLeft, newRight); 
    }
    public Node merge(Node head1, Node head2){
        Node mergedNode = new Node(-1); //Create a Temp LL
        Node temp = mergedNode;
        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        //Remaining Elements
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedNode.next;
    }

    public static void main(String args[]){
        MergeSortLL ll = new MergeSortLL();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        // ll.addFirst(5);
        //5->4->3->2->1
        ll.printLL();

        ll.head = ll.mergeSort(ll.head);
        ll.printLL();

    }
}
