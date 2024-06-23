import java.util.Stack;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Pallindrome {
    static boolean isPallindrome(Node head) {
        Node slow = head;
        boolean isPallin = true;
        Stack<Integer> s = new Stack<>();
        while(slow != null) {
            s.push(slow.data);
            slow = slow.next;
        }
        while(head != null){
            int val = s.pop();
            if(head.data != val) {
                isPallin = false;
            }
            head = head.next;
        }
        return isPallin;
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(3);
        Node six = new Node(2);
        Node seven = new Node(1);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;

        boolean result = isPallindrome(one);
        System.out.println("Pallindrome : "+result);
    }
}