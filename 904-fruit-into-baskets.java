class Solution {
    public int totalFruit(int[] fruits) {
        return getMaxLenOfSubarrayWithMaxKDistinctValues(fruits, 2);
    }
    
    /*public int getMaxLenOfSubarrayWithMaxKDistinctValues(int[] nums, int k) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        // Sliding window
        int maxLen = 0;
        int start = 0;
        for(int end = 0; end < nums.length; end++) {
            int valueAtEnd = nums[end];
            numIndexMap.put(valueAtEnd, end);
            if(numIndexMap.size() > k) {
                int indexToDelete = Collections.min(numIndexMap.values());
                numIndexMap.remove(nums[indexToDelete]);
                start = indexToDelete + 1;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        
        return maxLen;
    }*/
    public int getMaxLenOfSubarrayWithMaxKDistinctValues(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        // Sliding window
        int maxLen = 0;
        int start = 0;
        for(int end = 0; end < nums.length; end++) {
            int valueAtEnd = nums[end];
            freqMap.put(valueAtEnd, freqMap.getOrDefault(valueAtEnd, 0) + 1);
            while(freqMap.size() > k) {
                int valueAtStart = nums[start];
                freqMap.put(valueAtStart, freqMap.get(valueAtStart) - 1);
                if(freqMap.get(valueAtStart) == 0) {
                    freqMap.remove(valueAtStart);
                }
                start++;
                
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        
        return maxLen;
    }    
}
