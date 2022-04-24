class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int n : arr) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }
        
        Set<Integer> frequencySet = new HashSet<>();
        for(int f : countMap.values()) {
            if(frequencySet.contains(f)) {
                return false;
            }
            
            frequencySet.add(f);
        }
        
        return true;
    }
}
