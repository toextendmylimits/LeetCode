class Solution {
    /*public int missingNumber(int[] nums) {
       int result = nums.length;
        
        for(int i = 0; i < nums.length; i++) {
            result ^= i ^ nums[i];
        }
        
        return result;
    }*/
    public int missingNumber(int[] nums) {
       int i = 0;
        while(i < nums.length) {
            int correctPosition = nums[i];
            if(correctPosition < nums.length && nums[i] != nums[correctPosition]) {
                swap(nums, i, correctPosition);
            }
            else {
                i++;
            }
        }
        
        for(i = 0; i < nums.length; i++) {
            if(nums[i] != i) {
                return i;
            }
        }
        
        return nums.length;
    }    
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
