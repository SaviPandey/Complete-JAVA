import java.util.*;
public class InterleaveTwoHalves {
    public static void interleaveTwoHalves(Queue<Integer> q){
        int size = q.size();
        Queue<Integer> firstHalf = new LinkedList<>();

        for(int i = 0; i < size/2; i++) { //Insert first elements
            firstHalf.add(q.remove());
        }
        while(!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q =  new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        interleaveTwoHalves(q);
        while(!q.isEmpty()) {
            System.out.print(q.peek()+" ");
            q.remove();
        }
    }
}