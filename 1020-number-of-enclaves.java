class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if((r == 0 || r == m - 1 || c == 0 || c == n - 1) && grid[r][c] == 1)                 {
                    dfs(grid, r, c);
                }
            }
        }
        
        int result = 0;
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if(grid[r][c] == 1) {
                    result++;
                }
            }
        }
        
        return result;
    }
    
    private void dfs(int[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;
        if(r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0) {
            return;
        }
        
        grid[r][c] = 0;
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}
