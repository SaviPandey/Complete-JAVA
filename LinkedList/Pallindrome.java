public class Pallindrome {
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

    public void addLast(int data){
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

    //Slow-Fast Approach
    public Node findMid(Node head) { //helper Function
        Node slow = head ;
        Node fast = head ;

        while(fast != null && fast.next != null){
            slow = slow.next ;//+1
            fast = fast.next.next ; //+2
        }
        return slow; //Slow is the mid Node
    }
    public boolean checkPallindrome(){
        if(head == null || head.next == null){ //For empty list or List of only one element
            return true;
        }
       //Step-1 to find mid
       Node midNode = findMid(head);

       //Step-2 Reverse 2nd half of list
       Node prev = null;
       Node curr = midNode;
       Node next;
       while(curr != null){
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
       }
       //Step-3 Compare leftHalf and RightHalf
       Node left = head;
       Node right = prev;
       while(right != null){
        if(left.data != right.data){
            return false;
        }
        left = left.next;
        right = right.next;
       }
       return true;
    }

    public static void main(String args[]){
        Pallindrome p = new Pallindrome();
        p.addLast(1);
        p.addLast(2);
        p.addLast(2);
        // p.addLast(1);
        p.printLL();

        System.out.println(p.checkPallindrome());
    }
}
