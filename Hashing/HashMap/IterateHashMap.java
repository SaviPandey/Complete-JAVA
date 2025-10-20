package HashMap;
import java.util.*;
public class IterateHashMap {
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("Indonesia", 80);
        hm.put("Australia", 90);
        hm.put("US", 50);

        //Iterate
        Set<String> key = hm.keySet();
        System.out.println(key);

        //Loop
        for (String k : key) {
            System.out.print("Key = " +k+",value = "+hm.get(k)+" ");
        }
    }
}
