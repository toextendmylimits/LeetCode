class Solution {
    private static final int NO_NEXT_GREATER_NUMBER = -1;
    
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, NO_NEXT_GREATER_NUMBER);
        
        Stack<Integer> monotoneIncreasingStack = new Stack<>();
        for(int i = 0; i < nums.length * 2; i++) {
            while(!monotoneIncreasingStack.isEmpty() && nums[i % nums.length] > nums[monotoneIncreasingStack.peek()]) {
                int index = monotoneIncreasingStack.pop();
                result[index] = nums[i % nums.length];
                
            }
            monotoneIncreasingStack.push(i % nums.length);
        }
        
        return result;
    }
}
