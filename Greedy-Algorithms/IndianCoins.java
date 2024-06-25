import java.util.*;
public class IndianCoins {
    public static void main(String[] args) {
        int V = 121;
        Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000}; 
        int n = coins.length;
        Arrays.sort(coins , Comparator.reverseOrder()); //Sort this is descending Order

        int countOfCoins = 0;   //count of minimum coins/notes to make changes
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(coins[i] <= V) {
                while(coins[i] <= V) {
                    ans.add(coins[i]);
                    countOfCoins++;
                    V -= coins[i];
                }
            }    
        }
        System.out.println("Minimums number of Coins/notes : "+countOfCoins);

        for(int i=0; i<ans.size(); i++){
            System.out.print(ans.get(i)+" ");
        }
    }
}
