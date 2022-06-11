class KthLargest {
    private PriorityQueue<Integer> queue = new PriorityQueue<>();
    private int capacity;
    
    public KthLargest(int k, int[] nums) {
        this.capacity = k;
          for(int n : nums) {
              queue.offer(n);
              if(queue.size() > k) {
                  queue.poll();
              }
          }  
    }
    
    public int add(int val) {
        queue.offer(val);
        if(queue.size() > capacity) {
            queue.poll();
        }
        
        return queue.peek();
    }
}
/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
