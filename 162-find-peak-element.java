//Check whether nums[i] > nums[i + 1]
//Three case:
//1. All ascending
//2. All descending
//3. Ascend first and Descend later
class Solution {
    /*public int findPeakElement(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i + 1]) {
                return i;
            }
        }
        
        return nums.length - 1;
    }*/
    
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid + 1]) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        
        return right;
    }    
}
