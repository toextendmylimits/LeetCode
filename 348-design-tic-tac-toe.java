class TicTacToe {
    private char[][] board;
    private int size;
    private static final char PLAYER_ONE_SYMBOL = 'X';
    private static final char PLAYER_TWO_SYMBOL = 'O';
    
    public TicTacToe(int n) {
        board = new char[n][n];
        size = n;
    }
    
    public int move(int row, int col, int player) {
        char playerSymbol = getPalyerSymbol(player);
        board[row][col] = playerSymbol;
        // Check horizontal, vertical, digonal, anti-diagonal
        if(isSameOnHorizontal(row, playerSymbol) || isSameOnVertical(col, playerSymbol)
            || isSameOnDiagonal(row, col, playerSymbol) || isSameOnAntiDiagonal(row, col, playerSymbol)) {
            return player;
        }
        
        return 0;
    }
    
    private boolean isSameOnHorizontal(int row, char symbol) {
        for(int c = 0; c < size; c++) {
            if(board[row][c] != symbol) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isSameOnVertical(int col, char symbol) {
        for(int r = 0; r < size; r++) {
            if(board[r][col] != symbol) {
                return false;
            }
        }

        return true;
    }
    
    private boolean isSameOnDiagonal(int row, int col, char symbol) {
        if(row != col) {
            return false;
        }

        for(int r = 0; r < size; r++) {
            if(board[r][r] != symbol) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isSameOnAntiDiagonal(int row, int col, char symbol) {
        if(row != size - 1 - col) {
            return false;
        }

        for(int r = 0; r < size; r++) {
            if(board[r][size - 1 - r] != symbol) {
                return false;
            }
        }
        return true;
    }
    
    private char getPalyerSymbol(int player) {
        return player == 1? PLAYER_ONE_SYMBOL: PLAYER_TWO_SYMBOL;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
