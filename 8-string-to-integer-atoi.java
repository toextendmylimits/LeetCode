class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        int result = 0;
        int index = 0;
        int len = s.length();
        
        // Discard leading white spaces
        while(index < len && Character.isWhitespace(s.charAt(index))) {
            index++;
        }
        
        // Get sign
        if(index < len && s.charAt(index) == '+') {
            sign = 1;
            index++;
        }
        else if(index < len && s.charAt(index) == '-') {
           sign = -1;
            index++;
        }
        
        while(index < len && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            
            // Check overflow
            if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 
                                                  && digit > Integer.MAX_VALUE % 10)){
                return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            result = result * 10 + digit;
            index++;
        }
        
        return sign * result;
    }
}
