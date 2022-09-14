class Solution {
    // Greedy algorithm
    // If stock price on a given day is higher than its previou day, always buy from its previous day, and sell on that day, to get profit
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
