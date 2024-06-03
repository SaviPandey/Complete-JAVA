import java.util.*;
public class InbuiltSort {
    public static void main(String[] args) {
        int arr[] = {5, 3, 4, 1, 2};
        Arrays.sort(arr);  //basic 
        // Arrays.sort(arr, 0, 3); //start and end index
        // Integer arr[] = {5, 3, 4, 1, 2}; //Collection operates on objects not primitive types
        // Arrays.sort(arr, Collections.reverseOrder());   //Reverse order
        System.out.println(Arrays.toString(arr));

    }
}
