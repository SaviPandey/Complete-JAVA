import java.util.*;
public class QueueReversal {
    public static void queueReversal(Queue<Integer> q){
        if(q.isEmpty()){
            System.out.println("Queue is Empty");
            return;
        }
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()) {
            s.push(q.remove());
        }
        while(!s.isEmpty()) {
            q.add(s.pop());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        queueReversal(q);
        while(!q.isEmpty()) {
            System.out.print(q.peek()+" ");
            q.remove();
        }
    }

}
