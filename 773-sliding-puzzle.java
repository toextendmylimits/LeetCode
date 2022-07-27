class Solution {
    private static final int EMPTY_TILE = 0;
    private static final int[][] BOARD_SOLVED = { { 1, 2, 3 }, { 4, 5, 0 } };
    private static final String ROW_SEPARATOR = ";";
    private static final String COL_SEPARATOR = ",";
    public int slidingPuzzle(int[][] board) {
        String boardString = serialize(board);
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(boardString);
        visited.add(boardString);
        int moves = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String state = queue.poll();
                if(state.equals(serialize(BOARD_SOLVED))) {
                    return moves;
                }
                
                for(String nextState : getStatesAfterOneMove(state)) {
                    if(visited.contains(nextState)) {
                        continue;
                    }
                    
                    queue.offer(nextState);
                    visited.add(nextState);
                }
            }
            moves++;
        }
        
        return -1;
    }
    
    private List<String> getStatesAfterOneMove(String boardString) {
        int[][] board = deserialize(boardString);
        int rows = board.length;
        int cols = board[0].length;
        List<String> result = new ArrayList<>();
        int[] emptyTile = findEmptyTile(board);
        int currRow = emptyTile[0];
        int currCol = emptyTile[1];
        if(currRow == -1 || currCol == -1) {
            return result;
        }
        
        int[][] directions = new int[][] { { -1, 0 } , { 0, 1 }, { 1, 0 }, { 0, -1 } }; //move direction: top -> right -> bottom -> left
        for(int[] direction : directions) {
            int nextRow = currRow + direction[0];
            int nextCol = currCol + direction[1];
            if(nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) {
                continue;
            }
            
            int[][] nextBoard = cloneBoard(board);
            int temp = nextBoard[nextRow][nextCol];
            nextBoard[nextRow][nextCol] = nextBoard[currRow][currCol];
            nextBoard[currRow][currCol] = temp;
            result.add(serialize(nextBoard));
        }
        
        return result;
    }
    
    private int[][] cloneBoard(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] clone = new int[rows][cols];
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                clone[r][c] = board[r][c];
            }
        }
        
        return clone;
    } 
    
    private int[] findEmptyTile(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(board[r][c] == EMPTY_TILE) {
                    return new int[] { r, c };
                }
            }
        }
        
        return new int[] { -1, -1 };
    }
    
    private String serialize(int[][] board) {
        int rowLen = board.length;
        int colLen = board[0].length;
        StringBuilder result = new StringBuilder();
         for(int r = 0; r < rowLen; r++) {
            for(int c = 0; c < colLen; c++) {
                result.append(board[r][c]);
                if(c != colLen - 1) {
                    result.append(COL_SEPARATOR);
                }
            }
            if(r != rowLen - 1) {
                result.append(ROW_SEPARATOR);
            }
        }
        
        return result.toString();
    }
    
    private int[][] deserialize(String boardString) {
        String[] rows = boardString.split(ROW_SEPARATOR);
        
        int rowLen = rows.length;
        int[][] board = new int[rowLen][];
        for(int r = 0; r < rowLen; r++) {
            board[r] = Arrays.stream(rows[r].split(COL_SEPARATOR))
                .mapToInt(Integer::parseInt)
                .toArray();
        }
        return board;
    }    
}
