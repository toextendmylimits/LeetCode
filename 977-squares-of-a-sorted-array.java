class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int position = nums.length - 1;
        while(left <= right) {
            int largerAbsoluteValue = 0;
            int absoluteLeftValue = Math.abs(nums[left]);
            int absoluteRightValue = Math.abs(nums[right]);
            if(absoluteLeftValue > absoluteRightValue) {
                largerAbsoluteValue = absoluteLeftValue;
                left++;
            }
            else {
                largerAbsoluteValue = absoluteRightValue;
                right--;
            }
            
            result[position] = largerAbsoluteValue * largerAbsoluteValue;
            position--;
        }
        
        return result;
    }
}
