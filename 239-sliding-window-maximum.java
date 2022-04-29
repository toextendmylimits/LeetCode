class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> indexDeque = new ArrayDeque<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            if(!indexDeque.isEmpty() && indexDeque.peekFirst() < i - k + 1) {
                indexDeque.pollFirst();
            }
            
            while(!indexDeque.isEmpty() && nums[indexDeque.peekLast()] < nums[i]) {
                indexDeque.pollLast();
            }
            
            indexDeque.offerLast(i);
            
            if(i >= k - 1) {
                result[i - k + 1] = nums[indexDeque.peekFirst()];
            }
        }
           
        return result;
    }

    /*public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        
        for(int i = 0; i < nums.length - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);                
            }
            
            result[i] = max;          
        }
        
        return result;
    }*/
}
