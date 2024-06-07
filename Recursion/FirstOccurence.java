public class FirstOccurence {
    public static int firstOccurence(int arr[], int i, int key){
        if(i  == arr.length-1){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }
        return firstOccurence(arr, i+1, key);
    }
    public static void main(String[] args) {
        int arr[] = {8, 3, 5, 10, 2, 9};
        int key = 15;
        System.out.println(firstOccurence(arr, 0, key));

    }
}
