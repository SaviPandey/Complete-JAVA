import java.util.*;
public class ActivitySelection {
    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        //sorting
        int activities[][] = new int[start.length][3];
        for(int i=0; i <start.length; i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        //Lambda Function -> shortForm
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        //Sorted on the basis of end-time
        ArrayList<Integer> ans = new ArrayList<>();

        int maxAct = 1; // Selecting the 1st activity by-default
        ans.add(activities[0][0]); //add the index of 1st activity
        int lastEnd = activities[0][2];  //end time of 1st activity

        for(int i=1; i<end.length; i++) {
            if(activities[i][1] >= lastEnd) { //Non-overlapping activities
                ans.add(activities[i][0]);
                maxAct++;
                lastEnd = activities[i][2];
            }
        }
        System.out.println("Max Activities = "+maxAct);
        for(int i=0; i<ans.size(); i++){
            System.out.print("A"+ans.get(i)+" ");
        }
    }
}
