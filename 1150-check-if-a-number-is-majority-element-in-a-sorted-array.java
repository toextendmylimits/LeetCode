class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int firstIndex = findFirstIndex(nums, target);
        if(firstIndex < 0) {
            return false;
        }
        
        return findLastIndex(nums, target) - firstIndex >= nums.length / 2;
    }    
    
    /*public boolean isMajorityElement(int[] nums, int target) {
        int firstIndex = findFirstIndex(nums, target);
        if(firstIndex < 0) {
            return false;
        }
        
        int indexToCheck = firstIndex + nums.length / 2;
        if(indexToCheck >= nums.length) {
            return false;
        }
        
        return nums[indexToCheck] == target;
    }*/
    
    private int findFirstIndex(int[] nums, int target) {
        int result = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int middle = left + (right - left) / 2;
            int num = nums[middle];
            
            if(num == target) {
                result = middle;
                right = middle - 1;
            }
            else if(num > target) {
                right = middle - 1;
            }
            else {
               left = middle + 1; 
            }
        }
        
        return result;
    }
    
    private int findLastIndex(int[] nums, int target) {
        int result = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int middle = left + (right - left) / 2;
            int num = nums[middle];
            
            if(num == target) {
                result = middle;
                left = middle + 1;
            }
            else if(num < target) {
                left = middle + 1;
            }
            else {
               right = middle - 1; 
            }
        }
        
        return result;
    }    
}
