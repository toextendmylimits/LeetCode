class Solution {
    private static final int PASCAL_EDGE_VALUE = 1;
  
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(PASCAL_EDGE_VALUE));
        
        for(int rowIndex = 1; rowIndex < numRows; rowIndex++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> previousRow = triangle.get(rowIndex - 1);
            
            // First column is 1
            row.add(PASCAL_EDGE_VALUE);
            
            for(int columnIndex = 1; columnIndex <= rowIndex - 1; columnIndex++) {
                row.add(previousRow.get(columnIndex) + previousRow.get(columnIndex - 1));
            }
            
            // Last column is 1
            row.add(PASCAL_EDGE_VALUE);
            
            triangle.add(row);
        }
        
        return triangle;
    }
}
