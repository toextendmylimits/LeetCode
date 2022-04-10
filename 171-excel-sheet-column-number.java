class Solution {
    private static final int BASE_NUMBER = 26;
    
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        for(int i = 0; i < columnTitle.length(); i++) {
            char letter = columnTitle.charAt(i);
            int num = mapLetterToNum(letter);
            //sum += num * Math.pow(BASE_NUMBER, columnTitle.length() - 1 - i);
            sum *= BASE_NUMBER;
            sum += num;
        }
        
        return sum;
    }
    
    private int mapLetterToNum(char c) {
        return c - 'A' + 1;
    }
}
