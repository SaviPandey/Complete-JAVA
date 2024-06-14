import java.util.ArrayList;
public class FindMaxNum {
    public static void main(String args[]){
        int maxNum = Integer.MIN_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(89);
        list.add(7);
        list.add(9);
        list.add(25);
        list.add(24);

        for(int i=0; i<list.size(); i++){
            // if(list.get(i) > maxNum )
            //     maxNum = list.get(i);
            maxNum = Math.max(maxNum, list.get(i));
        }
        System.out.println("Maximum : "+maxNum);
        
    }
}
