import java.util.Arrays;
public class MinAbsoluteDiff {
    public static void main(String[] args) {
        // int A[] = {1, 4, 7, 8};
        // int B[] = {2, 3, 5, 6};

        int A[] = {1, 2, 3};
        int B[] = {3, 1, 2};

        Arrays.sort(A);
        Arrays.sort(B);

        int minAbsDiff = 0;
        for(int i=0; i< A.length; i++){
            int diff = Math.abs(A[i] - B[i]);
            minAbsDiff += diff;
        }
        System.out.println("Minimum Absolute Difference is: " + minAbsDiff);
    }
}
