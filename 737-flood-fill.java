class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) {
            return image;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { sr, sc });
        int origColor = image[sr][sc];
        image[sr][sc] = color;
        while(!queue.isEmpty()) {
            int[] coordinate = queue.poll();          
            
            int[][] directions = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1} }; // Direction: top, right, bottom,  left
            for(int[] direction : directions) {
                int nextRow = coordinate[0] + direction[0];
                int nextCol = coordinate[1] + direction[1];
                if(nextRow < 0 || nextRow >= image.length || nextCol < 0 || nextCol >= image[0].length || image[nextRow][nextCol] != origColor) {
                    continue;
                }
                
                image[nextRow][nextCol] = color;
                queue.add(new int[] { nextRow, nextCol });
            }            
        }
        
        return image;
    }
    
    
    /*public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) {
            return image;
        }
        
        dfs(image, 0, 0, image[sr][sc], color);
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int origColor, int replacementColor) {
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != origColor) {
            return;
        }
        
        image[sr][sc] = replacementColor;
        int[][] directions = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1} }; // Direction: top, right, bottom,  left
        for(int[] direction : directions) {
            dfs(image, sr + direction[0], sc + direction[1], origColor, replacementColor);
        }
    }*/
}
