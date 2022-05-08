class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if((r == 0 || r == m - 1 || c == 0 || c == n - 1) && grid[r][c] == 1)                 {
                    grid[r][c] = 0;

                    queue.offer(new Pair<>(r, c));
                    
                    while(!queue.isEmpty()) {
                        Pair<Integer, Integer> temp = queue.poll();
                        int row = temp.getKey();
                        int col = temp.getValue();
                        if(row - 1 >= 0 && grid[row - 1][col] == 1) {
                            grid[row - 1][col] = 0;
                            queue.offer(new Pair<>(row - 1, col));
                        }
                        
                        if(row + 1 < m && grid[row + 1][col] == 1) {
                            grid[row + 1][col] = 0;
                            queue.offer(new Pair<>(row + 1, col));
                        }    
                        
                        if(col - 1 >= 0 && grid[row][col - 1] == 1) {
                            grid[row][col - 1] = 0;
                            queue.offer(new Pair<>(row, col - 1));
                        }
                        
                        if(col + 1 < n && grid[row][col + 1] == 1) {
                            grid[row][col + 1] = 0;
                            queue.offer(new Pair<>(row, col + 1));
                        }                         
                    }
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
    
    /*public int numEnclaves(int[][] grid) {
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
    }*/
    
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
