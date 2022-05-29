class Solution {
    /*public void setZeroes(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        
        for(int r = 0; r < rowLen; r++) {
            for(int c = 0; c < colLen; c++) {
                if(matrix[r][c] == 0) {
                    rows.add(r);
                    cols.add(c);
                }
            }
        }
        
        for(int r = 0; r < rowLen; r++) {
            for(int c = 0; c < colLen; c++) {
                if(rows.contains(r) || cols.contains(c)) {
                    matrix[r][c] = 0;
                }
            }
        }
    }*/
    
    public void setZeroes(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        
        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;
        
        for(int c = 0; c < colLen; c++) {
            if(matrix[0][c] == 0) {
                isFirstRowZero = true;
                break;
            }
        }
        
        for(int r = 0; r < rowLen; r++) {
            if(matrix[r][0] == 0) {
                isFirstColZero = true;
                break;
            }
        }
                         
        for(int r = 1; r < rowLen; r++) {
            for(int c = 1; c < colLen; c++) {
                if(matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }
        
        for(int r = 1; r < rowLen; r++) {
            for(int c = 1; c < colLen; c++) {
                if(matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }
                         
        if(isFirstRowZero) {
            for(int c = 0; c < colLen; c++) {
                matrix[0][c] = 0;
            }
        }    
                         
        if(isFirstColZero) {
            for(int r = 0; r< rowLen; r++) {
                matrix[r][0] = 0;
            }
        }                         
    }    
}
