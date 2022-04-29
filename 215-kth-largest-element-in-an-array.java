class Solution {
    /*public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        
        for(int n : nums) {
            if(priorityQueue.size() < k) {
                priorityQueue.offer(n);
            }
            else if(priorityQueue.peek() < n) {
                priorityQueue.poll();
                priorityQueue.offer(n);
            }
        }
        
        return priorityQueue.peek();
    }*/
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        
        for(int n : nums) {
            priorityQueue.offer(n);
            if(priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        
        return priorityQueue.peek();
    }    
    
    /*public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        
        return nums[nums.length - k];
    }*/
}
