class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> sumCountMap = new HashMap<>();
        sumCountMap.put(0, 1);
        
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int target = sum - k;
            if(sumCountMap.containsKey(target)) {
                count += sumCountMap.get(target);
            }
            
            sumCountMap.put(sum, sumCountMap.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}
