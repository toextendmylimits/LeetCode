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

// BFS
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
                
                int currArea = bfs(grid, rows, cols, r, c, visited);
                maxArea = Math.max(maxArea, currArea);
            }
        }
        
        return maxArea;
    }
    
    private int bfs(int[][] grid, int rows, int cols, int r, int c, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { r, c });
        visited[r][c] = true;
        int area = 0;
        while(!queue.isEmpty()) {
            area += 1;
            int[] coordinate = queue.poll();
            for(int[] direction : directions) {
                int nextRow = coordinate[0] + direction[0];
                int nextCol = coordinate[1] + direction[1];
                if(nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || grid[nextRow][nextCol] == 0 || visited[nextRow][nextCol]) {
                continue;
                }
                
                queue.offer(new int[] { nextRow, nextCol });
                visited[nextRow][nextCol] = true;
            }    
        }
        
        return area;
    }
}
