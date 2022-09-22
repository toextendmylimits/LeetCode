class Solution {
    private static final int LEFT_RIGHT_EDGE = 1;
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(LEFT_RIGHT_EDGE));
        for(int i = 1; i < numRows; i++) {
            List<Integer> level = new ArrayList<>();
            
            // First
            level.add(LEFT_RIGHT_EDGE);
            for(int j = 1; j < i; j++) {
                List<Integer> prevLevel = triangle.get(i - 1);
                level.add(prevLevel.get(j - 1) + prevLevel.get(j));
            }
            
            // Last
            level.add(LEFT_RIGHT_EDGE);
            triangle.add(level);
        }
        
        return triangle;
    }
}
