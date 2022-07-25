// DFS
class Solution {
    static int[][] directions = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // Directions: top -> right -> bottom -> left
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == 0 || visited[r][c]) {
                    continue;
                }
                
                int currArea = dfs(grid, rows, cols, r, c, visited);
                maxArea = Math.max(maxArea, currArea);
            }
        }
        
        return maxArea;
    }
    
    private int dfs(int[][] grid, int rows, int cols, int r, int c, boolean[][] visited) {
        if(r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0 || visited[r][c]) {
            return 0;
        }
        
        visited[r][c] = true;
        int area = 1;
        for(int[] direction : directions) {
            int nextRow = r + direction[0];
            int nextCol = c + direction[1];
            area += dfs(grid, rows, cols, nextRow, nextCol, visited);
        }
        
        return area;
    }
}
