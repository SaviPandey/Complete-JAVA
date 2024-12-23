import java.util.HashMap;

public class BasicHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        //Insert
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);

        System.out.println(hm);

        //Get - O(1)
        int population = hm.get("India");
        System.out.println(population);

        //ContainsKey - O(1)

        System.out.println(hm.containsKey("India")); //true
        System.out.println(hm.containsKey("Indonesia")); //False

        //Remove - O(1)
        System.out.println(hm.remove("US")); //print the value of US
        System.out.println(hm);

        System.out.println(hm.remove("Indonesia")); //Null
        System.out.println(hm);

        //Size
        System.out.println(hm.size());

        //Emptiness Check
        System.out.println(hm.isEmpty());
    }
}
