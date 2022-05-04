class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        Set<Integer>[] rows = new HashSet[n];
        Set<Integer>[] columns  = new HashSet[n];
        for(int i = 0; i < n; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
        }
    
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                int val = matrix[r][c];
                
                if(rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);
                
                if(columns[c].contains(val)) {
                    return false;
                }
                columns[c].add(val);
            }
        }
        
        return true;
    }
  
    /*public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
    
        for(int r = 0; r < n; r++) {
            Set<Integer> row = new HashSet<>();
            Set<Integer> column  = new HashSet<>();
            for(int c = 0; c < n; c++) {
                if(!row.add(matrix[r][c])) {
                    return false;
                }
                
                if(!column.add(matrix[c][r])) {
                    return false;
                }
            }
        }
        
        return true;
    }*/  
}
