class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            count += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return count;
    }
    
    private int twoSumSmaller(int[] nums, int startIndex, int target) {
        int count = 0;
        int left = startIndex;
        int right = nums.length - 1;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum < target) {
                count += right - left;
                left++;
            }
            else {
                right--;
            }
        }
        
        return count;
    }
}
