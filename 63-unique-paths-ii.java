class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;
        int[][] dp = new int[rows][columns];
        
        for(int row = 0; row < rows && obstacleGrid[row][0] == 0; row++) {
            dp[row][0] = 1;
        }
        
        for(int column = 0; column < columns && obstacleGrid[0][column] == 0; column++) {
            dp[0][column] = 1;
        }
              
        for(int row = 1; row < rows; row++) {
            for(int column = 1; column < columns; column++) {
                if(obstacleGrid[row][column] == 1) { continue; }
                dp[row][column] = dp[row - 1][column] + dp[row][column - 1];
            }
        }
              
        return dp[rows - 1][columns - 1];
    }
}
