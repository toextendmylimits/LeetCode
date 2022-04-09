class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) { return 0; }
        if(nums.length == 1) { return nums[0]; }

        int resultConsiderFirst = robRange(nums, 0, nums.length - 2);
        int resultConsiderLast = robRange(nums, 1, nums.length - 1);
        return Math.max(resultConsiderFirst, resultConsiderLast);
    }
    
    public int robRange(int[] nums, int start, int end) {
        int moneyFromPrevious1 = 0;
        int moneyFromPrevious2 = 0;
        for(int house = start; house <= end; house++) {
            int money = Math.max(moneyFromPrevious1, moneyFromPrevious2 + nums[house]);
            moneyFromPrevious2 = moneyFromPrevious1;
            moneyFromPrevious1 = money;
        }
        
        return moneyFromPrevious1;
    }
}
