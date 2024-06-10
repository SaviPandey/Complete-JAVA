import java.util.*;
public class MergeSort {
    public static void mergeSort(int arr[] , int si, int ei){
        if (si >= ei) {
            return; // Base case: If there's only one element or none in the sub-array, return
        }
        int mid = si + (ei - si)/2 ;//(si+ei)/2
        mergeSort(arr, si, mid); //left part
        mergeSort(arr, mid+1, ei); //right part
        merge(arr, si , mid, ei);
    }
    public static void merge(int arr[], int si, int  mid, int ei){
        //left(0, 3)=4 and right(4, 6)=3 -> 6-0 =6 which is wrong thus (ei-si+1) size of temp arr
        int temp[] = new int[ei-si+1];
        int i = si; //iterator for left part
        int j = mid+1; //iterator for right part
        int k = 0; //ietrator for temp arr

        while(i <= mid && j <= ei){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++ ;
            } else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        //left part remaining elements
        while( i<= mid){
            temp[k++] = arr[i++];
        }
        //right part remaining
        while( j <= ei){
            temp[k++] = arr[j++];
        }
        //copy temp to original arr
        for(k=0, i=si; k<temp.length; k++, i++){
            arr[i] = temp[k];
        }

    }
    public static void main(String args[]){
        int arr[] = {6,3,9,5,2,9};
        mergeSort(arr, 0 ,arr.length-1);
        System.out.print(Arrays.toString(arr));
    }
}
