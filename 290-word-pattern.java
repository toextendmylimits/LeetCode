class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(pattern.length() != words.length) { return false; }
        
        Map<Character, Integer> letterIndexes = new HashMap<>();
        Map<String, Integer> wordIndexes = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            char letter = pattern.charAt(i);
            String word = words[i];
            if(!letterIndexes.getOrDefault(letter, -1).equals(wordIndexes.getOrDefault(word, -1))) {
                    return false;
            }
            
            if(!letterIndexes.containsKey(letter)) {
                letterIndexes.put(letter, i);
                wordIndexes.put(word, i);
            }
            
        }
        
        return true;
    }
}
