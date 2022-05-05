class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length;
        int columns = mat[0].length;
        
        int[] result = new int[rows * columns];
        
        int r = 0;
        int c = 0;
        int resultIndex = 0;
        while(resultIndex < rows * columns) {
            result[resultIndex++] = mat[r][c];
            
            if((r + c) % 2 == 0) {
                if(r - 1 >= 0 && c + 1 < columns) {
                    r--;
                    c++;
                }
                else if(r - 1 < 0 && c + 1 < columns) {
                    c++;
                }
                else if(r + 1 < rows && c + 1 >= columns) {
                    r++;
                }
            }
            else {
                if(r + 1 < rows && c - 1 >= 0) {
                    r++;
                    c--;
                }
                else if(r + 1 < rows && c - 1 < 0) {
                    r++;
                }
                else if(r + 1 >= rows && c + 1 < columns) {
                    c++;
                }
            }
        }
    
        
        return result;
    }
    
    /*public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length;
        int columns = mat[0].length;
        Map<Integer, List<Integer>> diagonalSumElements = new HashMap<>();
        int[] result = new int[rows * columns];
        
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < columns; c++) {
                int sum = r + c;
                int element = mat[r][c];
                if(!diagonalSumElements.containsKey(sum)) {
                   diagonalSumElements.put(sum, new ArrayList<>());
                }
                  
                diagonalSumElements.get(sum).add(element);
            }
        }
        
        int index = 0;
        for(Map.Entry<Integer, List<Integer>> entry : diagonalSumElements.entrySet()) {
            List<Integer> elements = entry.getValue();
            int sum = entry.getKey();
            if(sum % 2 == 0) {
                Collections.reverse(elements);
            }
            
            for(int e : elements) {
                result[index++] = e;
            }
        }
        
        return result;
    }*/
}
