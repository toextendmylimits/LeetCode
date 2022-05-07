class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        // Find first 0
        int slow = 0;
        while(slow < n && nums[slow] != 0) {
            slow++;
        }
        
        for(int fast = slow + 1; fast < n; fast++) {
            if(nums[fast] != 0) {
                nums[slow] = nums[fast];
                nums[fast] = 0;
                slow++;
            }
        }
    }
}
