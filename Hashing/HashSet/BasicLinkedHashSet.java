package HashSet;
import java.util.LinkedHashSet;

public class BasicLinkedHashSet {
    public static void main(String[] args) {
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Mumbai");
        lhs.add("Delhi");
        lhs.add("Bengaluru");
        lhs.add("Noida");

        System.out.println(lhs);
        lhs.remove("Delhi");
        System.out.print(lhs);

    }
}
