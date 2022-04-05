class Solution {
    private static final int HAPPY_NUMBER_TERMINAL_VALUE = 1;
    
    public boolean isHappy(int n) {
        Set<Integer> numbersSeen = new HashSet<>();
        
        while(n != HAPPY_NUMBER_TERMINAL_VALUE && !numbersSeen.contains(n)) {
            numbersSeen.add(n);
            n = getNextNumber(n);
        }
        
        return n == HAPPY_NUMBER_TERMINAL_VALUE;
    }
    
    private int getNextNumber(int n) {
        int sum = 0;
        while(n > 0) {
            int temp = n % 10;
            sum += temp * temp;
            n /= 10;
        }
        
        return sum;
    }
}
