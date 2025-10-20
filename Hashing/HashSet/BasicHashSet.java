package HashSet;
import java.util.HashSet;

public class BasicHashSet {
    public static void main(String args[]){
        HashSet<Integer> set = new HashSet<>();

        set.add(2);
        set.add(1);
        set.add(4);
        set.add(3);
        set.add(1);

        System.out.println(set);
        System.out.println(set.size());

        set.remove(1);
        System.out.println(set.contains(1));

        set.clear();
        System.out.println(set);
        System.out.println(set.size());

        System.out.println(set.isEmpty());
    }
}
