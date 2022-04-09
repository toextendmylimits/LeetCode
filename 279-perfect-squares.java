class Solution {
    private static final int MAX_VALUE = Integer.MAX_VALUE;
    
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, MAX_VALUE);
        dp[0] = 0;
        
        for(int i = 1; i * i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(j - i * i < 0) { continue; }
                
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        
        return dp[n];
    }
}
