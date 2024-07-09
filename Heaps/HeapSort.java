public class HeapSort {
    public static void heapify(int arr[] , int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        if(left < size && arr[left] > arr[maxIdx]) { //Chnage this for decending order
            maxIdx = left;
        }
        if(right < size && arr[right] > arr[maxIdx]) { //Chnage this for decending order
            maxIdx = right;
        }

        if(maxIdx != i) {
            //Swap
            int temp = arr[i];
            arr[i] =  arr[maxIdx];
            arr[maxIdx] = temp;
            heapify(arr, maxIdx, size);
        }
    }
    public static void heapSort(int arr[]) {
        int n = arr.length;
        //Step1 : Build A MaxHeap
        for(int i = n/2 ; i>=0 ; i--) {
            heapify(arr, i , n);
        }

        //Step2 : Push Largest at end
        for(int i = n-1 ; i > 0 ; i--) {
            //Swap :> largest-First with last
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 3};
        heapSort(arr);
        for(int i : arr) {
            System.out.print(i + " ");
        }    
    }
}
