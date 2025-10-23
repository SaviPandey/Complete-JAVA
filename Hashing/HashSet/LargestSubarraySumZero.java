package HashSet;
import java.util.HashMap;

// Time & Space Complexity
// Time: O(n)
// Space: O(n)

public class LargestSubarraySumZero {
    public static int largestSubarray(int[] arr){
        HashMap<Integer, Integer> hm = new HashMap<>();
        //(sum,  idx)

        int sum = 0;
        int len = 0;
        
        for(int j=0; j < arr.length; j++){
            sum += arr[j];
            if(sum == 0){
                len = j + 1;
            } else if(hm.containsKey(sum)){
                len = Math.max(len, j - hm.get(sum));
            } else{
                hm.put(sum, j);
            }
        }
        return len;

    }
    public static void main(String[] args) {
        // int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        int[] arr = {1, -1, 1, -1};
        System.out.println(largestSubarray(arr));
    }
}
