import java.util.ArrayList;
public class PairSum1 {
    //Brute-Force -> O(n^2)
    // public static boolean pairSum(ArrayList<Integer> list, int target){
    //     for(int i=0; i<list.size(); i++){
    //         for(int j=i+1; j<list.size(); j++){
    //             if((list.get(i)+list.get(j)) == target){
    //                 return true;
    //             } 
    //         }
    //     }
    //     return false;
    // }

    //Two-Pointer approach 
    public static boolean pairSum(ArrayList<Integer> list, int target){
        int n = list.size();
        int left = 0; 
        int right = n-1;
        while(left != right){
            int sum = list.get(left) + list.get(right);
            if(sum == target){
                return true;
            } else if(sum < target){
                left++;                     //because array is sorted
            } else {
                right--;
            }
        }
        return false;
    }
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        int target = 15;
        System.out.println(pairSum(list, target));
    }
}