class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstPosition = findFirstPosition(nums, target);
        int lastPosition = findLastPosition(nums, target);
        
        return new int[] { firstPosition, lastPosition };
    }
    
    private int findFirstPosition(int[] nums, int target) {
        int firstPosition = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int pivot = left + (right - left) / 2;
            int pivotValue = nums[pivot];
            if(pivotValue > target) {
                right = pivot - 1;
            }
            else if(pivotValue < target) {
                left = pivot + 1;
            }
            else {
                firstPosition = pivot;
                
                // Check whether there is target value on left of pivot
                right = pivot - 1;
            }
        }
        
        return firstPosition;
    }
    
    private int findLastPosition(int[] nums, int target) {
        int lastPosition = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int pivot = left + (right - left) / 2;
            int pivotValue = nums[pivot];
            if(pivotValue > target) {
                right = pivot - 1;
            }
            else if(pivotValue < target) {
                left = pivot + 1;
            }
            else {
                lastPosition = pivot;
                
                // Check whether there is target value on right of pivot
                left = pivot + 1;
            }
        }
        
        return lastPosition;
    } 
}
