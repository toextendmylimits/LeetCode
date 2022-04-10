// Solution 1 recurision, solution 2 iteration
class Solution {
    public double myPow(double x, int n) {
        long longValue = n;
        if(longValue < 0) {
            return calculatePositivePow(1/x, -longValue);
        }
        
        return calculatePositivePow(x, longValue);
    }
    
    private double calculatePositivePow(double x, long n) {
        if(n == 0) { return 1.0; }

        double halfPow = calculatePositivePow(x, n / 2);
        double squareOfHalfPow = halfPow * halfPow;
        
        return n % 2 == 0? squareOfHalfPow : squareOfHalfPow * x;
    }
    
    /*private double calculatePositivePow(double x, long n) {
        double result = 1.0;
        for(long i = n; i > 0; i /= 2) {
            if(i % 2 == 1) {
                result *= x;
            }
            x *= x;
        }
        
        return result;
    }*/    
}
