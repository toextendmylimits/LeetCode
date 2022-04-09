class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if(Math.abs(target) > sum) { return 0; }
        
        int sumPlusTarget = sum + target;
        if(sumPlusTarget % 2 != 0) { return 0; }
        
        int wantedSum = sumPlusTarget / 2;
        int[] dp = new int[wantedSum + 1];
        dp[0] = 1; 
        
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for(int tempSum = wantedSum; tempSum >= num; tempSum--) {
                dp[tempSum] += dp[tempSum - num];
            }
        }
        
        return dp[wantedSum];
    }
}
