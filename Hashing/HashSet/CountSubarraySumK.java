package HashSet;
import java.util.HashMap;

public class CountSubarraySumK {
    public static int countSubarrays(int arr[], int k){
        HashMap<Integer, Integer> hm = new HashMap<>();
        //(sum, count)

        //Initialize with (0, 1) (because subarray starting from 0 can also sum to k)
        hm.put(0, 1);

        int sum = 0;
        int count = 0;

        for(int num : arr){
            sum += num;
            if(hm.containsKey(sum - k)){
                count += hm.get(sum - k);
            }

            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    public static void main(String args[]){
        int arr[] = {1, 2, 3};
        int k = 3;
        System.out.println("Number of Subarray's with Sum = "+k+" is "+countSubarrays(arr, k));
    }
}
