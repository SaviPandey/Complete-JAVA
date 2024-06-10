//Inversion Count -> How far the array is from being sorted. If Already sorted they inversion count = 0
public class InversionCount {
    public static int mergeSort(int arr[], int left, int right){
        int invCount = 0;
        if(right > left){
            int mid = (left + right)/2;
            invCount = mergeSort(arr, left, mid);
            invCount += mergeSort(arr, mid+1, right);
            invCount += merge(arr, left, mid+1, right);
        }
        return invCount;
    }
    public static int merge(int arr[], int left, int mid, int right){
        int i= left, j = mid, k=0;
        int invCount = 0;
        int temp[] = new int[(right - left +1)];

        while((i<mid) && (j<=right)){
            if(arr[i] <= arr[j]){
                temp[k] = arr[i];
                k++;
                i++;
            }
            else{
                temp[k] = arr[j];
                invCount += (mid - i);
                k++;
                j++;
            }
        }
        //Remaining
        while(i < mid){
            temp[k] = arr[i];
            k++;
            i++;
        }
        while(j <= right){
            temp[k] = arr[j];
            k++;
            j++;
        }
        //Enter temp in original array
        for(i=left, k=0; i<=right; i++, k++){
            arr[i] = temp[k];
        }
        return invCount;
    }

    public static int getInversion(int arr[]){
        int n = arr.length;
        return mergeSort(arr, 0, n-1);
    }
    public static void main(String args[]){
        int arr[] = {1, 20, 6, 4, 5};
        System.out.println("Inversion Count -> "+ getInversion(arr));
    }
}
