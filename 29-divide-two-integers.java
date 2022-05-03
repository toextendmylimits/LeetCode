class Solution {
    private static final int HALF_INT_MIN = -(Integer.MAX_VALUE / 2 + 1);
    
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        int negatives = 2;
        
        if(dividend > 0) {
            negatives--;
            dividend = -dividend;
        }
        
        if(divisor > 0) {
            negatives--;
            divisor = -divisor;
        }
        
       int quotient = 0;
        while(divisor >= dividend) {
            int value = divisor;
            int powerOfTwo = -1;
            while(value > HALF_INT_MIN && value + value >= dividend) {
                value += value;
                powerOfTwo += powerOfTwo;
            }
            
            quotient += powerOfTwo;
            dividend -= value;
        }
        
        if(negatives != 1) {
            return -quotient;
        }
        
        return quotient;
    }
}
