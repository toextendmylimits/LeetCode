class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int coin : coins) {
            for(int sum = coin; sum <= amount; sum++) {
                if(dp[sum - coin] == Integer.MAX_VALUE) { continue; }
                
                dp[sum] = Math.min(dp[sum], dp[sum - coin] + 1);
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE? -1 : dp[amount];
    }
}
