import java.util.ArrayList;
public class StoreWater {

    public static int storeWater(ArrayList<Integer> list){
        int n = list.size();
        int maxWaterStored = Integer.MIN_VALUE;
        for(int i=0 ;  i<n  ; i++){
            for(int j=i+1; j<n; j++){
                int waterStored = Math.min(list.get(i), list.get(j)) * (j - i);
                maxWaterStored = Math.max(maxWaterStored, waterStored);
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

        System.out.print(storeWater(list));
    }
}