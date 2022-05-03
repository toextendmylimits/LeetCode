class Solution {
    public boolean areNumbersAscending(String s) {
        int prevNum = 0;
        int curNum = 0;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                curNum = curNum * 10 + (ch - '0');
            }
            else if(curNum > 0) {
                if(prevNum >= curNum) {
                    return false;
                }
                
                prevNum = curNum;
                curNum = 0;
            }
        }
        
        return curNum == 0 || curNum > prevNum;
    }
}
