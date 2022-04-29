class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        List<Character> uniqueChars = new ArrayList<>(frequencyMap.keySet());
        Collections.sort(uniqueChars, (a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        /*Character[] uniqueChars = new Character[frequencyMap.size()];
        int index = 0;
        for(Character k : frequencyMap.keySet()) {
            uniqueChars[index++] = k;
        }
        
        Arrays.sort(uniqueChars, (a, b) -> frequencyMap.get(b) - frequencyMap.get(a));*/
        
        StringBuilder result = new StringBuilder();
        for(Character uc : uniqueChars) {
            int frequency = frequencyMap.get(uc);
            while(frequency > 0) {
                result.append(uc);
                frequency--;
            }
        }
        
        return result.toString();
    }
}
