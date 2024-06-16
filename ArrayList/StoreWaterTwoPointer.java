import java.util.ArrayList;
public class StoreWaterTwoPointer {

    public static int storeWaterOpt(ArrayList<Integer> list){
        int n = list.size();
        int left = 0, right = n-1;
        int maxWaterStored = Integer.MIN_VALUE;

        while( left < right) {

            int waterStored = Math.min(list.get(left), list.get(right)) * (right - left);

            maxWaterStored = Math.max(maxWaterStored, waterStored);

            if(list.get(left) < list.get(right)){
                left++;
            } else {
                right--;
            }
        }
        return maxWaterStored;

    }
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);

        System.out.print(storeWaterOpt(list));
    }
}