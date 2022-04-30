class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for(String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<String> queue = new PriorityQueue<>((a, b) -> {
            if(frequencyMap.get(a) == frequencyMap.get(b)) {
                return b.compareTo(a);
            }
            
            return frequencyMap.get(a) - frequencyMap.get(b);
        });
        
        List<String> uniqueWords = new ArrayList<>(frequencyMap.keySet());
        for(int i = 0; i < uniqueWords.size(); i++) {
            queue.offer(uniqueWords.get(i));
            if(queue.size() > k) {
                queue.poll();
            }
        }
        
        List<String> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            result.add(queue.poll());
        }
        
        Collections.reverse(result);
        
        return result;
    }
    
    /*public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for(String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        
        List<String> uniqueWords = new ArrayList<>(frequencyMap.keySet());
        Collections.sort(uniqueWords, (a, b) -> {
            if(frequencyMap.get(a) == frequencyMap.get(b)) {
                return a.compareTo(b);
            }
            
            return frequencyMap.get(b) - frequencyMap.get(a);
        });
        
        List<String> result = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            result.add(uniqueWords.get(i));
        }
        
        return result;
    }*/
}
