class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        Set<Character>[] rows = new HashSet[n];
        Set<Character>[] columns = new HashSet[n];
        Set<Character>[] boxes = new HashSet[n];
        for(int i = 0; i < n; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                char val = board[r][c];
                if(val == '.') {
                    continue;
                }
                
                if(rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);
                
                if(columns[c].contains(val)) {
                    return false;
                }
                columns[c].add(val);
                
                int boxerId = (r / 3) * 3 + c / 3;
                if(boxes[boxerId].contains(val)) {
                    return false;
                }
                boxes[boxerId].add(val);
            }
        }
        
        return true;
    }
}
