class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }
        
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> frequencyMap.getOrDefault(a, 0) - frequencyMap.getOrDefault(b, 0));
        
        for(int n : frequencyMap.keySet()) {
            queue.offer(n);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        
        int[] result = new int[k];
        for(int j = k - 1; j >= 0; j--) {
            result[j] = queue.poll();
        }
        
        return result;
    }    
    /*public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }
        
        int[] uniqueValues = new int[frequencyMap.size()];
        int i = 0;
        for(int n : frequencyMap.keySet()) {
            uniqueValues[i++] = n;
        }
        
        uniqueValues = Arrays.stream(uniqueValues)
            .boxed()
            .sorted((a, b) -> frequencyMap.getOrDefault(b, 0) - frequencyMap.getOrDefault(a, 0))
            .mapToInt(Integer::intValue)
            .toArray();
        
        int[] result = new int[k];
        for(int j = 0; j < k; j++) {
            result[j] = uniqueValues[j];
        }
        
        return result;
    }*/
}
