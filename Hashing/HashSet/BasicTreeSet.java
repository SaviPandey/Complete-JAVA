package HashSet;
import java.util.TreeSet;

public class BasicTreeSet {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>();
        ts.add("Mumbai");
        ts.add("Delhi");
        ts.add("Bengaluru");
        ts.add("Noida");

        System.out.println(ts);  //Sorted output :- O(n) operations due to sorting
    }
}
