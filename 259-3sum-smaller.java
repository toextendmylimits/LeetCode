class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while(low < high) {
                if(nums[i] + nums[low] + nums[high] < target) {
                    count += high - low;
                    low++;
                }
                else{
                    high--;
                }
            }
        }
        
        return count;
    }
}
