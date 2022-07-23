class Solution {
    public int removeElement(int[] nums, int val) {
        int nextElementIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[nextElementIndex] = nums[i];
                nextElementIndex++;
            }
        }
        
        return nextElementIndex;
    }
}
