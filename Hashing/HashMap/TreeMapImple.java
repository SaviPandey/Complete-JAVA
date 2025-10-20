package HashMap;
import java.util.TreeMap;
public class TreeMapImple {
    public static void main(String args[]){
        //Keys are sorted , if strings then alphabetically sorted
        //Internal data structure used is Red Black trees (self balanced BST)
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 200);
        tm.put("USA", 350);
        tm.put("Indonesia", 100);
        tm.put("China", 340);

        System.out.println(tm);
    }
}
