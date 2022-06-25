class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int middle = left + (right - left) / 2;
            if(nums[middle] > nums[right]) {
                left = middle + 1;
            }
            else {
                right = middle;
            }
        }
        
        return nums[left];
    }
    
    public int findMin(int[] nums) {
        int result = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] <= nums[nums.length - 1]) {
                result = nums[mid];
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        
        return result;
    }    
}
