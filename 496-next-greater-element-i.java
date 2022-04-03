class Solution {
    private static final int NO_GREATER_ELEMENT = -1;
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length]; 
        Arrays.fill(ans, NO_GREATER_ELEMENT);
        
        Map<Integer, Integer> valueIndexMap = getValueIndexMap(nums1);
        
        Stack<Integer> monotoneIncreasingStack = new Stack<>();
        for(int j = 0; j < nums2.length; j++) {
            while(!monotoneIncreasingStack.isEmpty() && nums2[j] > monotoneIncreasingStack.peek()) {
                if(valueIndexMap.containsKey(monotoneIncreasingStack.peek())) {
                    int index = valueIndexMap.get(monotoneIncreasingStack.peek());
                    ans[index] = nums2[j];
                }
                monotoneIncreasingStack.pop();
            }
            
            monotoneIncreasingStack.push(nums2[j]);
        }
        
        return ans;
    }
    
    private Map<Integer, Integer> getValueIndexMap(int[] nums) {
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            valueIndexMap.put(nums[i], i);
        }
        
        return valueIndexMap;
    }
}
