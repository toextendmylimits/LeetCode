class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        // Initialize base condition, i.e. first row and first column
        for(int row = 0; row < m; row++) {
            dp[row][0] = 1;
        }
        
        for(int column = 0; column < n; column++) {
            dp[0][column] = 1;
        }
        
        for(int row = 1; row < m; row++) {
            for(int column = 1; column < n; column++) {
                dp[row][column] = dp[row - 1][column] + dp[row][column - 1];
            }
        }
        
        return dp[m - 1][n - 1];
    }
}
