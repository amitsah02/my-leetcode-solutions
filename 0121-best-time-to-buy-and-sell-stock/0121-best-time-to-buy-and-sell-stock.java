class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyPrice = Integer.MAX_VALUE; 
        for(int i = 0 ; i<prices.length; i++){
            if(buyPrice < prices[i]){
                // profit 
             int profit = prices[i] - buyPrice;
             maxProfit = Math.max(profit, maxProfit);
            }else{
             buyPrice = prices[i];
            }
        }
          return  maxProfit;
    }
}