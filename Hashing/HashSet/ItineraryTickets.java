package HashSet;
import java.util.HashMap;

public class ItineraryTickets {
    public static String getStarted(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>();

        // Reverse mapping: destination -> source
        for (String src : tickets.keySet()) {
            revMap.put(tickets.get(src), src);
        }

        // Find the starting city (not a destination)
        for (String src : tickets.keySet()) {
            if (!revMap.containsKey(src)) {
                return src;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStarted(tickets);

        // Print the complete itinerary
        System.out.print("Itinerary: ");
        while (start != null && tickets.containsKey(start)) {
            System.out.print(start + " -> ");
            start = tickets.get(start);
        }
        System.out.println(start);
    }
}
