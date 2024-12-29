import java.util.HashMap;
public class MajorityElement {
    public static void main(String args[]) {
        int[] nums = {1, 3, 2, 5, 1, 3, 1, 5, 1};
        int n = nums.length;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i < n; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        for(Integer key : hm.keySet()) {
            if(hm.get(key) > n / 3) {
                System.out.print(key + " ");
            }
        }

    }
    //Time Complexity : O(n)
}
