import java.util.*;
// Numbers that occurs only once and there adjacent numbers are not present 
// Ex: x = 10 , then 9 and 11 are not present in array
public class LoneNumber {
    public static ArrayList<Integer> findLonely(ArrayList<Integer> A){
        Collections.sort(A);
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=1; i<A.size() - 1; i++){
            if(A.get(i-1) + 1 < A.get(i) && A.get(i) + 1 < A.get(i+1)){
                list.add(A.get(i));
            }    
        }
        if(A.size() == 1){
            list.add(A.get(0));
        }
        if(A.size() > 1){
            if(A.get(0) + 1 < A.get(1))
                list.add(A.get(1));
            if(A.get(A.size()-2) + 1 < A.get(A.size() - 1)){
                list.add(A.get(A.size()-1));
            }
        }
        return list;

    }
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(6);
        list.add(5);
        list.add(8);

        System.out.println(findLonely(list));
    }
}
