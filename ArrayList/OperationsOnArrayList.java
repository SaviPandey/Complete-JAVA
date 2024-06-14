import java.util.ArrayList;
public class OperationsOnArrayList {
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        //Add Operation
        list.add(1); //O(1)
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.err.println(list);

        list.add(1, 9); //O(n)
        System.err.println(list);

        // //Get Operation
        // int element = list.get(2); //O(1)
        // System.out.println(element);

        // //Remove Operation
        // list.remove(2);  //O(n)
        // System.out.println(list);

        // //Set element at Index
        // list.add(3);
        // list.set(2, 10);  //O(n)
        // System.out.println(list);

        // //Contains 
        // System.out.println(list.contains(10));  //O(n)
        // System.out.println(list.contains(11));
    }
}