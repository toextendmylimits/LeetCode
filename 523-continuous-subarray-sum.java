class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(k == 0) { return false; }
        
        Map<Integer, Integer> seen = new HashMap<>();        
        int runningSum = 0;
        for(int i = 0; i < nums.length; i++) {
            runningSum += nums[i];           
            runningSum %= k;

            if(runningSum == 0 && i >= 1) {
                return true;
            }
            
            if(seen.containsKey(runningSum)) {
                if(i - seen.get(runningSum) > 1) { return true; }
            }
            else {
                seen.put(runningSum, i);
            }
        }
        
        return false;
    }
}
