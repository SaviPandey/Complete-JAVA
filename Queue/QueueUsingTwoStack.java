import java.util.*;
public class QueueUsingTwoStack {
    static class Queue {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        public boolean isEmpty() {
            return s1.isEmpty();
        }
        public void add(int data) {
            //Step-1 : POP from s1 and push to s2 until s1 is empty
            while(!isEmpty()) {
                s2.push(s1.pop());
            }

            s1.add(data); //Add new data into S1

            while(!s2.isEmpty()) { //transfer previous data from s2 -> s1
                s1.push(s2.pop());
            }
        }
        public int remove() {
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            return s1.pop();
        }
        public int peek() {
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            return s1.peek();
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
