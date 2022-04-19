class Solution {
    public int arraySign(int[] nums) {
        int negativeNumCount = 0;
        for(int n : nums) {
            if(n == 0) {
                return 0;
            }
            
            if(n < 0) {
              negativeNumCount += 1;  
            }
        }
        
        return negativeNumCount % 2 == 0? 1 : -1; 
    }
}
