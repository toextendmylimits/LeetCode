class Solution {
    /*public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        
        int longest = 0;
        for(int value : dp) {
            longest = Math.max(longest, value);
        }
        
        return longest;
    }*/
    public int findLengthOfLCIS(int[] nums) {
        int previous = 1;
        int longest = 1;
        
        for(int i = 1; i < nums.length; i++) {
            int current = 1;

            if(nums[i] > nums[i - 1]) {
                current = previous + 1;
                previous = current;
            }
            else {
                previous = 1;
            }

            longest = Math.max(longest, current);
        }
        
        return longest;
    }    
}
