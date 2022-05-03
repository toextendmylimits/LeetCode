class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int k = n - 2;
        int l = n - 1;
        
        // Find first digit from end that can be swapped to make a bigger permuation
        for(; k >= 0; k--) {
            if(nums[k] < nums[k + 1]) {
                break;
            }
        }
        
        // Can't find bigger permuation
        if(k < 0) {
            reverse(nums, 0, nums.length - 1);  
        }
        else {
            // Find a number than is larger than k, and is closer than others
            for(; l > k; l--) {
                if(nums[l] > nums[k]) {
                    break;
                }
            } 

            swap(nums, l, k);

            // Reverse to make sorted acendingly
            reverse(nums, k + 1, nums.length - 1);            
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start, end);
            start++; end--;
        }
    }
}
