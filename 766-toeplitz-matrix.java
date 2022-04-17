class Solution {
    /*public boolean isToeplitzMatrix(int[][] matrix) {
        for(int row = matrix.length - 1; row >= 1; row--) {
            int[] cellsInRow = matrix[row];
            for(int column = cellsInRow.length - 1; column >= 1; column--) {
                if(cellsInRow[column] != matrix[row - 1] [column - 1]) {
                    return false;
                }
            }
        }
        
        return true;
    }*/
    
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int row = 1; row < matrix.length; row++) {
            for(int column = 1; column < matrix[row].length; column++) {
                if(matrix[row][column] != matrix[row - 1] [column - 1]) {
                    return false;
                }
            }
        }
        
        return true;
    }    
}
