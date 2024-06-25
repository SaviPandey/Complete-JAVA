import java.util.*;
public class JobSequencing {
    static class Job {
        int id;
        int deadline;
        int profit;

        public Job(int i, int d, int p){
            id = i;
            deadline = d;
            profit = p;
        }
    }
    public static void main(String[] args) {
        int jobsInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};
        
        ArrayList<Job> jobs = new ArrayList<>();

        for(int i=0; i < jobsInfo.length; i++){
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }
        Collections.sort(jobs, (obj1, obj2) -> (obj2.profit - obj1.profit));  //For descending order , and for ascending (a,b) -> a.profit - b.profit

        int time = 0; 
        int maxProfit = 0;
        ArrayList<Integer> seq = new ArrayList<>();

        for(int i=0; i<jobs.size() ; i++){
            Job curr = jobs.get(i);
            if(curr.deadline > time){
                seq.add(curr.id);
                time++;
                maxProfit += curr.profit;
            }
        }
        System.out.println("Maximum Profit "+maxProfit);
        for(int i=0; i < seq.size(); i++) {
            System.out.print(seq.get(i)+" ");
        }
        System.out.println();
    }
}
