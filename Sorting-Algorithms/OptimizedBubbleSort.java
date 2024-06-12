import java.util.Arrays;
public class OptimizedBubbleSort{
    public static void modifiedBubbleSort(int arr[]){
        for(int turn=0; turn<arr.length; turn++){
            boolean swapped = false;
            for(int j=0; j<arr.length-1-turn; j++){
                //swap
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(swapped == false){
                break;
            }
        }
    }
    public static void main(String args[]){
        int arr[] = {1, 2, 3, 4, 5};
        modifiedBubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}