class Solution {
   /*public int[] topKFrequent(int[] nums, int k) {
        if(k == nums.length) {
            return nums;
        }  
        
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            queue.offer(entry);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        
        int[] result = new int[k];
        for(int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll().getKey();
        }
        
        return result;
    } */
    public int[] topKFrequent(int[] nums, int k) {
        if(k == nums.length) {
            return nums;
        }  
        
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }
        
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> freqMap.get(a) - freqMap.get(b));
        for(int n : freqMap.keySet()) {
            queue.offer(n);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        
        int[] result = new int[k];
        for(int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll();
        }
        
        return result;
    }     
}
