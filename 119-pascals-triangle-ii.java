class Solution {
    private static final int PASCAL_TRIANGLE_EDGE = 1;
    
    public List<Integer> getRow(int rowIndex) {
        List<Integer> previousRow = new ArrayList<>();
        previousRow.add(PASCAL_TRIANGLE_EDGE);
        
        if(rowIndex == 0) {
            return previousRow;
        }
        
        previousRow.add(PASCAL_TRIANGLE_EDGE);
        if(rowIndex == 1) {
            return previousRow;
        }
        
        for(int i = 2; i <= rowIndex; i++) {
            List<Integer> currentRow = new ArrayList<>();
            
            currentRow.add(PASCAL_TRIANGLE_EDGE);
                
            for(int j = 1; j <= i -1; j++) {
                currentRow.add(previousRow.get(j) + previousRow.get(j - 1));
            }
            
            currentRow.add(PASCAL_TRIANGLE_EDGE);
            
            previousRow = currentRow;
        }
            
        return previousRow;
    }
}
