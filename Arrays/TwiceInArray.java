public class TwiceInArray {
    public static boolean distinctArray(int arr[]){
        int n = arr.length;
        if(n==1){
            return false;
        }
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i] == arr[j]){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(distinctArray(arr));
        
    }
}
