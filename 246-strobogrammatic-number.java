class Solution {
    private static final Map<Character, Character> ROTATED_DIGITS = Map.of('0', '0', '1', '1', '6', '9', '8', '8', '9', '6');
    
    public boolean isStrobogrammatic(String num) {
        for(int left = 0, right = num.length() - 1; left <= right; left++, right--) {
            char leftChar = num.charAt(left);
            char rightChar = num.charAt(right);
            if(!ROTATED_DIGITS.containsKey(leftChar) || ROTATED_DIGITS.get(leftChar) != rightChar)  { 
                return false;
            }
        }
        
        return true;
    }
}
