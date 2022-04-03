class Solution {
    // Greedy algorithm
    public int maxProfit(int[] prices) {
        int accumulatedProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            int potentialProfit = prices[i] - prices[i - 1];
            if(potentialProfit > 0) {
                accumulatedProfit += potentialProfit;
            }
        }
        
        return accumulatedProfit;
    } 
}
