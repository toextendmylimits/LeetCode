class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int numOfIslands = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    numOfIslands++;
                    grid[i][j] = '0';
                    
                    Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
                    queue.add(new Pair<>(i, j));
                    while(!queue.isEmpty()) {
                        Pair<Integer, Integer> temp = queue.poll();
                        int row = temp.getKey();
                        int col = temp.getValue();
                        
                        if(row - 1 >= 0 && grid[row - 1][col] == '1') {
                            queue.offer(new Pair<>(row - 1, col));
                            grid[row - 1][col] = '0';
                        }
                        
                        if(row + 1 < m && grid[row + 1][col] == '1') {
                            queue.offer(new Pair<>(row + 1, col));
                            grid[row + 1][col] = '0'; 
                        }
                        
                        if(col - 1 >= 0 && grid[row][col - 1] == '1') {
                            queue.offer(new Pair<>(row, col - 1));
                            grid[row][col - 1] = '0';
                        }
                        
                        if(col + 1 < n && grid[row][col + 1] == '1') {
                            queue.offer(new Pair<>(row, col + 1));
                            grid[row][col + 1] = '0'; 
                        }                        
                    }
                }
            }
        }
        
        return numOfIslands;
    }
    
    /*public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int numOfIslands = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    numOfIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        
        return numOfIslands;
    }*/
    
    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if(i < 0 || i >= m || j < 0 || j >=n || grid[i][j] == '0') {
            return;
        }
        
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}

// DFS use visited array
class Solution {
    int[][] directions = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // Direction: top -> right -> bottom -> left
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == '0' || visited[r][c]) {
                    continue;
                }
                count++;
                dfs(grid, rows, cols, r, c, visited);
            }
        }
        
        return count;
    }
    
    private void dfs(char[][] grid, int rows, int cols, int r, int c, boolean[][] visited) {
        if(r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == '0' || visited[r][c]) {
            return;
        }
        
        visited[r][c] = true;
        for(int[] direction : directions) {
            int nextRow = r + direction[0];
            int nextCol = c + direction[1];
            dfs(grid, rows, cols, nextRow, nextCol, visited);
        }
    }
}
