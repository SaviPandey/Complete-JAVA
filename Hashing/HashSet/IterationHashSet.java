package HashSet;
import java.util.HashSet;
import java.util.Iterator;

public class IterationHashSet {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();

        cities.add("Mumbai");
        cities.add("Delhi");
        cities.add("Bengaluru");
        cities.add("Noida");

        //First Method :- Using Iterators
        Iterator itr = cities.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        //Second Method: Using Advanced-for-loop
        for(String city: cities){
            System.out.print(city+" ");
        }
    }
}
