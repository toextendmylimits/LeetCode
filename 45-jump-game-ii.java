class Solution {
    public int jump(int[] nums) {
        int currentMaxReach = 0;
        int nextMaxReach = 0;
        int jumps = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            nextMaxReach = Math.max(nextMaxReach, i + nums[i]);
            if(i == currentMaxReach) {
                jumps++;
                currentMaxReach = nextMaxReach;
            }
        }
        
        return jumps;
    }
}
