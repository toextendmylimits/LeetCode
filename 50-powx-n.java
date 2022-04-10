class Solution {
    public double myPow(double x, int n) {
        if(n < 0) {
            return calculatePositivePow(1/x, -n);
        }
        
        return calculatePositivePow(x, n);
    }
    
    private double calculatePositivePow(double x, int n) {
        if(n == 0) { return 1.0; }

        double halfPow = calculatePositivePow(x, n / 2);
        double squareOfHalfPow = halfPow * halfPow;
        
        return n % 2 == 0? squareOfHalfPow : squareOfHalfPow * x;
    }
}
