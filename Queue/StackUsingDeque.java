import java.util.*;
public class StackUsingDeque {
    static class Stack {
        Deque<Integer> d = new LinkedList<>();

        public boolean isEmpty() {
            return d.isEmpty();
        }
        public void push(int data) {
            d.addLast(data);
        }
        public int pop() {
            if(d.isEmpty()){
                System.out.println("Stack is Empty");
                return -1;
            }
            int top = d.removeLast();
            return top;
        }
        public int peek(){
            if(d.isEmpty()){
                System.out.println("Stack is Empty");
                return -1;
            }
            return d.getLast();
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while(!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
