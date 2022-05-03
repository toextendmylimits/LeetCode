class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) { return s; }
        
        List<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < Math.min(s.length(), numRows); i++) {
            rows.add(new StringBuilder());
        }
        
        int currentRow = 0;
        boolean goingDown = false;
        for(char ch : s.toCharArray()) {
            rows.get(currentRow).append(ch);

            if(currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            
            currentRow += goingDown? 1 : -1;
        }
        
        StringBuilder result = new StringBuilder();
        for(StringBuilder row : rows) {
            result.append(row);
        }
        
        return result.toString();
    }
}
