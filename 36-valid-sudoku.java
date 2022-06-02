class Solution {
    /*public boolean isValidSudoku(char[][] board) {
        int len = board.length;
        Set<Character>[] rows = new HashSet[len];   
        Set<Character>[] cols = new HashSet[len];  
        Set<Character>[] boxes = new HashSet[len];  
        
        for(int i = 0; i < len; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for(int r = 0; r < len; r++) {
            for(int c = 0; c < len; c++) {
                char val = board[r][c];
                if(val == '.') {
                    continue;
                }
                
                if(!rows[r].add(val) || !cols[c].add(val) ||
                  !boxes[(r / 3) * 3 + c / 3].add(val)) {
                    return false;
                }
            }
        }
        
        return true;
    }*/
    public boolean isValidSudoku(char[][] board) {
        int len = board.length;
        Set<String> seen = new HashSet<>();
        for(int r = 0; r < len; r++) {
            for(int c = 0; c < len; c++) {
                char val = board[r][c];
                if(val == '.') {
                    continue;
                }
                
                if(!seen.add("row " + r + " has " + val) || !seen.add("col " + c + " has " + val) |
                  !seen.add("box " + (r / 3 * 3 + c / 3)  + " has " + val)) {
                    return false;
                }
            }
        }
        
        return true;
    }    
}
