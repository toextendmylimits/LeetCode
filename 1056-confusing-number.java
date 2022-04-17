class Solution {
    private static final Map<Character, Character> ROTATED_DIGITS = Map.of('0', '0', '1', '1', '6', '9', '8', '8', '9', '6');
    
    public boolean confusingNumber(int n) {
        String digitsStr = String.valueOf(n);
        
        boolean isDifferentAfterRotation = false;
        for(int left = 0, right = digitsStr.length() - 1; left <= right; left++, right--) {
            char leftChar = digitsStr.charAt(left);
            char rightChar = digitsStr.charAt(right);
            if(!ROTATED_DIGITS.containsKey(leftChar) || !ROTATED_DIGITS.containsKey(rightChar)) {
                return false;
            }
            
            if(ROTATED_DIGITS.get(leftChar) != rightChar) {
                isDifferentAfterRotation = true;
            }
        }
        
        return isDifferentAfterRotation;
    }
}
