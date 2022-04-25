class Solution {  
    public boolean isAlienSorted(String[] words, String order) {
        int[] charIndexMapping = new int[26];
        for(int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            charIndexMapping[c - 'a'] = i;
        }
        
        for(int i = 0; i < words.length - 1; i++) {
            if(isBigger(words[i], words[i + 1], charIndexMapping)) {
                return false;
            }
        }
        
        return true;
    } 
    
    private boolean isBigger(String word1, String word2, int[] charIndexMapping) {
        int len1 = word1.length();
        int len2 = word2.length();
        
        for(int i = 0; i < len1 && i < len2; i++) {
            char char1 = word1.charAt(i);
            char char2 = word2.charAt(i);
            if(char1 != char2) {
                return charIndexMapping[char1 - 'a'] > charIndexMapping[char2 - 'a'];
            }           
        }
        
        return len1 > len2;
    }    
    
    /*public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        for(int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            charIndexMap.put(c, i);
        }
        
        for(int i = 0; i < words.length - 1; i++) {
            if(isAfterLexico(words[i], words[i + 1], charIndexMap)) {
                return false;
            }
        }
        
        return true;
    } 
    
    private boolean isAfterLexico(String word1, String word2, Map<Character, Integer> charIndexMap) {
        int len1 = word1.length();
        int len2 = word2.length();
        
        for(int i = 0; i < len1 && i < len2; i++) {
            if(i < len1 && i < len2) {
                char char1 = word1.charAt(i);
                char char2 = word2.charAt(i);
                if(char1 != char2) {
                    return charIndexMap.get(char1) > charIndexMap.get(char2);
                }
            }           
        }
        
        return len1 > len2;
    }*/
}
