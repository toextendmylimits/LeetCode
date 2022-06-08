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
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int n : nums) {
            maxHeap.offer(n);
        }
        
        for(int i = 1; i < k; i++) {
            maxHeap.poll();            
        }
        
        return maxHeap.peek();
    }
    
    /*public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int n : nums) {
            minHeap.offer(n);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        return minHeap.peek();
    }*/
    
    /*public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        
        return nums[nums.length - k];
    }*/
}
