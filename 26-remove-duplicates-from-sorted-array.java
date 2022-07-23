class Solution {
    public int removeDuplicates(int[] nums) {
        int distinctNumIndex = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[distinctNumIndex]) {
                distinctNumIndex++;
                nums[distinctNumIndex] = nums[i];
            }
        }
        
        return distinctNumIndex + 1;
    }
}
