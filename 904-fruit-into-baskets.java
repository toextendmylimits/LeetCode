class Solution {
    private static final int BASKETS_COUNT = 2;
    
    public int totalFruit(int[] fruits) {
        return findMaxSubArrayLengthWithKDistinctElements(fruits, BASKETS_COUNT);
    }
    
    private int findMaxSubArrayLengthWithKDistinctElements(int[] nums, int maxDistinctElementCount) {
        int maxSubArrayLength = Integer.MIN_VALUE;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            int windowEndValue = nums[windowEnd];    
            frequencyMap.put(windowEndValue, frequencyMap.getOrDefault(windowEndValue, 0) + 1);
            
            while(frequencyMap.size() > maxDistinctElementCount) {
                int windowStartValue = nums[windowStart];
                frequencyMap.put(windowStartValue, frequencyMap.getOrDefault(windowStartValue,                      0) - 1);
                if(frequencyMap.get(windowStartValue) == 0) {
                    frequencyMap.remove(windowStartValue);
                }
                windowStart++;
            }
            
            maxSubArrayLength = Math.max(maxSubArrayLength, windowEnd - windowStart + 1);
        }
        
        return maxSubArrayLength;
    }
}
