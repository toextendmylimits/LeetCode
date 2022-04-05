class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        
        // dp[i] represent the maximum product of the numbers that i break into
        for(int i = 3; i <= n; i++) {
            for(int j = 1; j <= i - j; j++) {
                /* If i is broken into mulitple numbers including j, two options:
                   1. j and i - j, and i - j isn't broken anymore
                   2. j and i - j, and i - j is broken into multiple numbers
                   
                */ 
                dp[i] = Math.max(dp[i], Math.max(j * (i-j), j * dp[i - j]));
            }
        }
        
        return dp[n];
    }
}
