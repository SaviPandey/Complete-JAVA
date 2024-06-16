import java.util.ArrayList;

public class PairSum2 {
    // Brute-Force -> O(n^2)
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

    // 2- Pointer approach using Modular arithmatic
    public static boolean pairSum(ArrayList<Integer> list, int target){
        int breakPoint = -1;
        int n = list.size();
        for(int i = 0; i<n ; i++){
            if(list.get(i) > list.get(i+1)){
                breakPoint = i;
                break;
            }
        }
        int left = breakPoint + 1; //smallest
        int right = breakPoint; //Largest
        while( left != right){
            //case 1
            if(list.get(left)+list.get(right) == target){
                return true;
            }
            //case 2 
            else if((list.get(left)+list.get(right)) < target){
                left = (left + 1) % n;
            }
            //case 3 
            else {
                right = (n + right - 1) % n;
            }
        }
        return false;
    }
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        int target = 15;
        System.out.println(pairSum(list, target));
    }
}
