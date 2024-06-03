import java.util.Arrays;
public class PrefixArray {
    public static void prefixArraySum(int number[]){
        int currSum =0;
        int maxSum = Integer.MIN_VALUE;
        int prefixArray[] = new int[number.length];
        prefixArray[0] = number[0];

        //Prefix Array calculation
        for(int i=1 ; i<prefixArray.length ; i++){
            prefixArray[i] = prefixArray[i-1] + number[i];
        }
        System.out.println(Arrays.toString(prefixArray));


        //Sum of prefixArray
        for(int i=0 ; i<number.length ; i++){
            int start =i;
            for(int j=i ; j<number.length ; j++ ){
                int end =j;

                currSum = start==0 ? prefixArray[end] : prefixArray[end] - prefixArray[start-1] ;
                
                if(maxSum < currSum){
                    maxSum = currSum;
                }
            }   
        }
        System.out.print("Max Sum :"+maxSum);



    }
    public static void kadane(int numbers[]){
        int currSum=0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<numbers.length; i++){
            currSum = currSum + numbers[i];
            if(currSum < 0){
                currSum =0;
            }
            maxSum = Math.max(currSum, maxSum);

        }
        System.out.println("MaxSum : "+maxSum);
    }

    public static void main(String[] args) {
        // int numbers[] = {2,4,6,8,10};
        // prefixArraySum(numbers);

        int numbers[] = {-1,-2,-3,-4,-5};
        kadane(numbers);
        
        

    }
    
}
