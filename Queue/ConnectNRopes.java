import java.util.*;
public class ConnectNRopes {
    public static int minCost(int arr[], int n){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            pq.add(arr[i]);
        }
        int res = 0;
        while(pq.size() > 1){
            int first = pq.remove();
            int second = pq.remove();

            res += first + second;
            pq.add(first + second);
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[] = {4, 3, 2, 6};
        int n = arr.length;
        System.out.println("Minimum Cost to connect " + n + " ropes is " + minCost(arr, n));
    }
}
