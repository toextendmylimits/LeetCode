class Solution {
    /*public boolean isPowerOfThree(int n) {
        if(n <= 0) { return false; }
        
        while(n % 3 == 0 ) {
            n = n / 3;
        }
        
        return n == 1;
    }*/
    public boolean isPowerOfThree(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }    
}
