package HashSet;
import java.util.HashSet;

public class CountDistinct {
    public static int countDistinctElements(int nums[]){
        HashSet<Integer> hs = new HashSet<>();

        for(Integer n: nums){
            hs.add(n);
        }
        return hs.size();
    }
    public static void main(String[] args) {
        int nums[] = {4, 3, 2, 5, 6, 7, 3, 4, 2, 1};
        System.out.println(countDistinctElements(nums));
    }
}
