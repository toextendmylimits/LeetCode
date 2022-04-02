class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int middle = low + (high - low) / 2;
            int middleValue = nums[middle];
            if(middleValue > target) {
                high = middle - 1;
            }
            else if(middleValue < target) {
                low = middle + 1;
            }
            else {
                return middle;
            }
        }
        
        // Be mindful to return low which is also high + 1. If unclear, try to use two numbers to understand
        return low;
    }
}
