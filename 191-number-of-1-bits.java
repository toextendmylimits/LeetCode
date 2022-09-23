public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ones = 0;
        while(n != 0) {
            if((n & 1) == 1) {
                ones++;
            }
            
            n >>>= 1;
        }
        
        return ones;
    }
}
