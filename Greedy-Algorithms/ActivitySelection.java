import java.util.*;
public class ActivitySelection {
    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        //Sorted on the basis of end-time
        ArrayList<Integer> ans = new ArrayList<>();

        int maxAct = 1; // Selecting the 1st activity by-default
        ans.add(0); //add the index of 1st activity
        int lastEnd = end[0];  //end time of 1st activity

        for(int i=1; i<end.length; i++) {
            if(start[i] >= lastEnd) { //Non-overlapping activities
                ans.add(i);
                maxAct++;
                lastEnd = end[i];
            }
        }
        System.out.println("Max Activities = "+maxAct);
        for(int i=0; i<ans.size(); i++){
            System.out.print("A"+ans.get(i)+" ");
        }
    }
}
