class Solution {
    public int diagonalSum(int[][] mat) {
        int sideLength = mat.length;
        int sum = 0;
        
        for(int i = 0; i < sideLength; i++) {
            sum += mat[i][i];
            sum += mat[i][sideLength - 1 - i];
        }
        
        if(sideLength % 2 == 1) {
            int middle = sideLength / 2;
            sum -= mat[middle][middle];
        }
        
        return sum;
    }
}
