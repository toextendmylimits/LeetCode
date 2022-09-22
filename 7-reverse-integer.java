class Solution {
    // Repeatedly pop the last digit of x, and push it to the back of the reversed number
    public int reverse(int x) {
        int result = 0;
        while(x != 0) {
            int remainder = x % 10;            
            // Check overflow
            if(result > 0) {
                int tenthOfMax = Integer.MAX_VALUE / 10 ;
                if(result > tenthOfMax|| (result == tenthOfMax && remainder > Integer.MAX_VALUE % 10)) {
                    return 0;
                }
            }
            else {
                int tenthOfMin = Integer.MIN_VALUE / 10;
                if(result < tenthOfMin || (result == tenthOfMin && remainder < Integer.MIN_VALUE % 10)) {
                    return 0;
                }
            }
            
            result = result * 10 + remainder;
            x /= 10;
        }
        
        return result;
    }
}
