import java.util.ArrayList;
public class Monotone {
    public static boolean isMonotonic(ArrayList<Integer> list){
        boolean incr = true;
        boolean decr = true;
        for(int i=0; i<list.size()-1; i++){
            if(list.get(i) > list.get(i+1))
                incr = false;
            if(list.get(i) < list.get(i+1))
                decr = false;
        }
        return incr || decr;
    }
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(8);
        list.add(10);

        System.out.println(isMonotonic(list));
    }
}
