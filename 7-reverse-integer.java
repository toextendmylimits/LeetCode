class Solution {
    public int reverse(int x) {
        long result = 0;
        while(x != 0) {
            int pop = x % 10;
            /*if(result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10  && pop > 7) {
                return 0;
            }
            
            if(result < Integer.MIN_VALUE / 10 || result == Integer.MIN_VALUE / 10 && pop < -8) {
                return 0;
            }*/
            
            result = result * 10 + pop;
            x /= 10;
        }
        
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) { return 0; }
        
        return (int)result;
    }
}
