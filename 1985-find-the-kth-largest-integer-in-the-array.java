class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> {
            if(a.length() == b.length()) {
                return a.compareTo(b);
            }
            else {
                return a.length() - b.length();
            }
        });
        
        for(String n : nums) {
            minHeap.offer(n);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        return minHeap.peek();
    }
}
