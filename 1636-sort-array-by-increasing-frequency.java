class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Arrays.stream(nums)
            .forEach(n -> frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1));
        
        return Arrays.stream(nums)
            .boxed()
            .sorted((a, b) -> {
                int frequencyA = frequencyMap.get(a);
                int frequencyB = frequencyMap.get(b);
                if(frequencyA == frequencyB) {
                    return b - a;
                }
                else {
                    return frequencyA - frequencyB;
                }
            })
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
