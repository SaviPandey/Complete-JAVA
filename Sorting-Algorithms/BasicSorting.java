public class BasicSorting {
    //Bubble Sort
    public static void bubbleSort(int arr[]){
        for(int turn=0; turn<arr.length-1; turn++){
            for(int j=0; j<arr.length-1-turn; j++){
                if(arr[j]>arr[j+1]){
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    //Selection SOrt
    public static void selectionSort(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            int minPos =i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[minPos] > arr[j]){
                    minPos = j;
                }
            }
            //swap
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }
    //Insertion Sort
    public static void insertionSort(int arr[]){
        for(int i=1; i<arr.length ; i++){
            int curr = arr[i];
            int prev = i-1;
            while(prev >= 0 && arr[prev] > curr ){
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = curr;
        }
    }
    //Counting Sort
    public static void countSort(int arr[]){
        int larger = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            larger = Math.max(larger, arr[i]);
        }
        int count[] = new int[larger+1];

        for(int i=0; i<arr.length; i++){
            count[arr[i]]++;
        }
        //sort
        int j=0;
        for(int i=0; i<count.length; i++){
            while(count[i] > 0){
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }    
    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {3,6,2,1,8,7,4,5,3,1};
        insertionSort(arr);
        printArr(arr);
    }
}
