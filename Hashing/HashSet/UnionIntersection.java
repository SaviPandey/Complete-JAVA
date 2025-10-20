package HashSet;
import java.util.HashSet;

// Complexity:
// Union: O(n + m)
// Intersection: O(n + m)
// Space: O(n)

public class UnionIntersection {
    public static int unionCount(int arr1[], int arr2[]){
        HashSet<Integer> hs = new HashSet<>();
        for(int n: arr1){
            hs.add(n);
        }
        for(int n: arr2){
            hs.add(n);
        }
        return hs.size();
    }
    public static int intersectionCount(int arr1[], int arr2[]){
        HashSet<Integer> hs = new HashSet<>();

        int count=0;
        for(int n: arr1){
            hs.add(n);
        }
        for(int n: arr2){
            if(hs.contains(n)){
                count++; 
                hs.remove(n);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};

        System.out.println("Union: "+unionCount(arr1, arr2));
        System.out.println("Intersection: "+intersectionCount(arr1, arr2));
    }
}
