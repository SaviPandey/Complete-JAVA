import java.util.*;
public class SlidingWindowMax {
    static class Pair implements Comparable<Pair>{
        int val;
        int idx;
        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
        @Override 
        public int compareTo(Pair p2) {
            //Ascending
            //return this.val - p2.val;
            //Descending
            return p2.val - this.val;
        }
    }
    public static void main(String[] args) {
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3; //Window Size
        int res[] = new int[arr.length - k + 1];// n - k + 1

        //Step1 - Add first K elements in Queue
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0; i<k; i++) {
            pq.add(new Pair(arr[i], i));
        }

        res[0] = pq.peek().val; //Largest in first Window

        //Step2 - Slide the Window and Remove elements which have idx out of window 
        for(int i = k ; i < arr.length; i++) {
            //Remove Out elements of Window
            while(pq.size() > 0 && pq.peek().idx <= (i - k)) {
                pq.remove();
            }
            pq.add(new Pair(arr[i], i));
            res[i - k + 1] = pq.peek().val;
        }
        //Print the Result
        for(int i=0; i<res.length ; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
