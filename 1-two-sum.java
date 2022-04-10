class Solution {
    public int[] twoSum(int[] nums, int target) {       
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int supplement = target - num;
            if(valueIndexMap.containsKey(supplement)) {
                return new int[] { valueIndexMap.get(supplement), i};
            }
            
            valueIndexMap.put(num, i);         
        }
        
        return null;
    }
}
