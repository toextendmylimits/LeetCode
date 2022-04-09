class Solution {
    /*public int rob(int[] nums) {
        if(nums == null || nums.length == 0) { return 0;}
        if(nums.length < 2) { return nums[0]; }
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int house = 2; house < nums.length; house++) {
            dp[house] = Math.max(dp[house - 1], dp[house - 2] + nums[house]);
        }
        
        return dp[nums.length - 1];        
    }*/
    
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) { return 0;}
        if(nums.length < 2) { return nums[0]; }
        
        int moneyFromPrevious1 = Math.max(nums[0], nums[1]);
        int moneyFromPrevious2 = nums[0];   
        
        int money = 0;
        for(int house = 2; house < nums.length; house++) {
            money = Math.max(moneyFromPrevious1, moneyFromPrevious2 + nums[house]);
            moneyFromPrevious2 = moneyFromPrevious1;
            moneyFromPrevious1 = money;           
        }
        
        return moneyFromPrevious1;        
    }    
}
