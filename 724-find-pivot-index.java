class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int sum = 0;
        for(int n : nums) {
            sum += n;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(leftSum == sum - leftSum - nums[i]) {
                return i;
            }
            
            leftSum += nums[i];
        } 
        
        return -1;
    }
}
