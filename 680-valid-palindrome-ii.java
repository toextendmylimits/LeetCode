class Solution {
    public boolean validPalindrome(String s) {    
        for(int start = 0, end = s.length() - 1; start < end; start++, end--) {
            if(s.charAt(start) != s.charAt(end)) {
                return isPalindrome(s, start, end - 1) || isPalindrome(s, start + 1, end);
            }
        }
        
        return true;
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        for(; start < end; start++, end--) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
        }
        
        return true;
    }
}
