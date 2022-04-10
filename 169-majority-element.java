class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> numFrequencyMap = new HashMap<>();
        for(int num : nums) {
            numFrequencyMap.put(num, numFrequencyMap.getOrDefault(num, 0) + 1);
            if(numFrequencyMap.get(num) > nums.length / 2) {
                return num;
            }
        }
        
        return 0;
    }
}
