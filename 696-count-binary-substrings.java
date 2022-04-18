class Solution {
    /*public int countBinarySubstrings(String s) {
        int previousRunLength = 0;
        int currentRunLength = 1;
        int result = 0;
        
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i - 1)) {
                currentRunLength++;
            }
            else {
                previousRunLength = currentRunLength;
                currentRunLength = 1;
            }
            
            if(previousRunLength >= currentRunLength) {
                result++;
            }
        }
        
        return result;
    }*/
    
    public int countBinarySubstrings(String s) {
        int previous1RunLength = 0;
        int currentRunLength = 1;
        int result = 0;
        
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i - 1)) {
                currentRunLength++;
            }
            else {
                result += Math.min(previousRunLength, currentRunLength);
                previousRunLength = currentRunLength;
                currentRunLength = 1;
            }
        }
        
        return result += Math.min(previousRunLength, currentRunLength);
    }    
}
