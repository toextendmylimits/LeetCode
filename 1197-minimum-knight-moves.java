class Solution {
    static int[][] DIRECTIONS = new int[][] { { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2}
                                            , { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2} };
    public int minKnightMoves(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int[] root = new int[] { 0, 0 };
        queue.offer(root);
        visited.add(getHash(0,0));
        int steps = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] coordinate = queue.poll();
                if(coordinate[0] == x && coordinate[1] == y) {
                    return steps;
                }                
                for(int[] direction : DIRECTIONS) {
                    int[] nextCoordinate = new int[] { coordinate[0] + direction[0], coordinate[1] + direction[1] };
                    if(visited.contains(getHash(nextCoordinate[0], nextCoordinate[1]))) {
                        continue;
                    }

                    queue.offer(nextCoordinate);
                    visited.add(getHash(nextCoordinate[0], nextCoordinate[1]));
                }                
            }
            
            steps++;
        }
        
        return steps;
    }

    private String getHash(int x, int y) {
        return x + "," + y;
    }
}
