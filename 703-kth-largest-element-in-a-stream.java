class KthLargest {
    private final PriorityQueue<Integer> priorityQueue;
    private final int queueSize;
    
    public KthLargest(int k, int[] nums) {
        queueSize = k;
        priorityQueue = new PriorityQueue<Integer>();
        Arrays.stream(nums)
            .forEach(n -> add(n));
    }
    
    public int add(int val) {
        if(priorityQueue.size() < queueSize) {
            priorityQueue.offer(val);
        }
        else if(priorityQueue.peek() < val) {
            priorityQueue.poll();
            priorityQueue.offer(val);
        }
        
        return priorityQueue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
