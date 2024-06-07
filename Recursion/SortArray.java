public class SortArray {
    public static boolean checkSort(int arr[], int i){
        if(i == arr.length-1){
            return true;
        }
        if(arr[i] > arr[i+1]){
            return false;
        }
        return checkSort(arr, i+1);
    }
    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 5, 2};
        System.out.println(checkSort(arr, 0));;
    }
}
