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

Boyer–Moore Voting
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int majority = 0;
        for(int n : nums) {
            if(count == 0) {
                majority = n;
            }
            
            count += n == majority ? 1 : -1;
        }
        
        return majority;
    }
}
