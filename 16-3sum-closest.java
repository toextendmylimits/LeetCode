class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length && diff != 0; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while(low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                int currentDiff = sum - target;
                if(Math.abs(diff) > Math.abs(currentDiff)) {
                    diff = currentDiff;
                }
                if(sum < target) {
                    low++;
                }
                else {
                    high--;
                }
            }
        }
        
        return diff + target;
    }
}
