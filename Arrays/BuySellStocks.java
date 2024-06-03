public class BuySellStocks {
    public static int buyAndSellStocks(int prices[]){
        int n = prices.length;
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit =0;

        for(int i=0; i<n; i++){
            if(buyPrice < prices[i]){
                int profit = prices[i] - buyPrice; //Today's profit
                maxProfit = Math.max(maxProfit , profit);
            } else{
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4}; //O(n)
        System.out.println(buyAndSellStocks(prices));
    }
    
}
