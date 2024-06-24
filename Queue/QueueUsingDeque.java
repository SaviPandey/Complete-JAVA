
import java.util.*;
public class QueueUsingDeque {
    static class Queue {
        Deque<Integer> d = new LinkedList<>();

        public boolean isEmpty() {
            return d.isEmpty();
        }

        public void add(int data) {
            d.addLast(data);
        }
        public int remove() {
            return d.removeFirst();
        }
        public int peek() {
            return d.getFirst();
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()) {
            System.out.print(q.peek()+" ");
            q.remove();
        }
    }
}
