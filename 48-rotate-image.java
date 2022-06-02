class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }
    
    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for(int r = 0; r < n; r++) {
            for(int c = r + 1; c < n; c++) {
                int temp = matrix[c][r];
                matrix[c][r] = matrix[r][c];
                matrix[r][c] = temp;
            }
        }
    }
    
    public void reflect(int[][] matrix) {
        int n = matrix.length;
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n / 2; c++) {
                int temp = matrix[r][n - 1 - c];
                matrix[r][n - 1 - c] = matrix[r][c];
                matrix[r][c] = temp;
            }
        }
    }
}
