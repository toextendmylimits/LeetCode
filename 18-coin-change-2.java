class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        
        for(int i = 0; i < coins.length; i++) {
            int coinValue = coins[i];
            for(int j = coinValue; j <= amount; j++) {
                dp[j] += dp[j - coinValue];
            }
        }
        
        return dp[amount];
    }
}
