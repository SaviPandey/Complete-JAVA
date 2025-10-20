package HashMap;
import java.util.*;
public class LinkedHashMapImple {
    public static void main(String args[]){
        //Order of Insertion is saved because Doubly LinkedList is used , rest all the operations are same
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 200);
        lhm.put("USA", 300);
        lhm.put("China", 150);

        System.out.println(lhm);
    }


}
