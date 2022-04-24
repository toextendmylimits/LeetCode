class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> firstIndexMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        int result = 0;
        int degree = 0;
        
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            firstIndexMap.putIfAbsent(num, i);
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            
            int currentCount = countMap.get(num);
            if(currentCount > degree) {
                degree = currentCount;
                result = i - firstIndexMap.get(num) + 1;
            }
            else if(currentCount == degree) {
                result = Math.min(result, i - firstIndexMap.get(num) + 1);
            }         
        }
        
        return result;
    }
}
