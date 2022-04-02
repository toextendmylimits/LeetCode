class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            sum += nums[windowEnd];
            
            while(sum >= target) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                
                sum -= nums[windowStart];
                windowStart++;
            }
        }
        
        return minLength == Integer.MAX_VALUE? 0 : minLength;
    }
}
