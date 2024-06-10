//Recursion-5
public class TowerOfHanoi {
    public static void towerOfHanoi(int n, String src, String helper, String dest){
        if(n == 1){
            System.out.println("Tranfer disk "+n+ " from "+src+" to "+ dest);
            return ;
        }

        //transfer top n-1 from src to helper using dest as 'helper'
        towerOfHanoi(n-1, src, dest, helper); 

        //transfer nth from src to dest
        System.out.println("Tranfer disk "+n+ " from "+src+" to "+ dest);

        //transfer n-1 from helper to dest using src as 'helper'
        towerOfHanoi(n-1, helper, src, dest);
    }
    public static void main(String args[]){
        int n=2;
        towerOfHanoi(n, "A", "B", "C");
    }
}
