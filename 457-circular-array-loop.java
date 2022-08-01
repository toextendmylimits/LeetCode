class Solution {
    public boolean circularArrayLoop(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int slow = i;
            int fast = i;
            boolean isForward = nums[i] > 0;
            do {
               slow = findNextIndex(nums, slow, isForward);
                fast = findNextIndex(nums, fast, isForward);
                if(fast != -1) {
                    fast = findNextIndex(nums, fast, isForward);
                }
            } while(slow != -1 && fast != -1 && slow != fast);
                
            if(slow != -1 && slow == fast) {
                return true;
            }
        }
        
        return false;
    }
    
    private int findNextIndex(int[] nums, int currentIndex, boolean isForward) {
        boolean direction = nums[currentIndex] > 0;
        if(direction != isForward) {
            return -1;
        }
        
        int nextIndex = (currentIndex + nums[currentIndex]) % nums.length;
        
        // Wrap around for negative index
        if(nextIndex < 0) {
            nextIndex += nums.length;
        }
        
        // One element cycle
        if(nextIndex == currentIndex) {
            return -1;
        }
        
        return nextIndex;
    }
}
