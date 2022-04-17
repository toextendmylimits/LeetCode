class Solution {
    public char findTheDifference(String s, String t) {
        char extra = t.charAt(t.length() - 1);
 
        for(int i = 0; i < s.length(); i++) {
            extra ^= s.charAt(i) ^ t.charAt(i);
        }
        
        return extra;
    }
    
    /*public char findTheDifference(String s, String t) {
        char[] sortedS = getSortedCharArray(s);
        char[] sortedT = getSortedCharArray(t);
        
        int i = 0;
        for(; i < sortedS.length; i++) {
            if(sortedS[i] != sortedT[i]) {
                return sortedT[i];
            }
        }
        
        return sortedT[i];
    }*/
    
    private char[] getSortedCharArray(String s) {
        char[] result = s.toCharArray();
        Arrays.sort(result);
        
        return result;
    }
    
    /*public char findTheDifference(String s, String t) {
        Map<Character, Integer> frequencyMap = getCharFrequencyMap(s);
        
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int frequency = frequencyMap.getOrDefault(c, 0);
            if(frequency == 0) {
                return c;
            }
            else {
               frequencyMap.put(c, frequencyMap.get(c) - 1);
            }
        }
        
        return '\0';
    }
    
    private Map<Character, Integer> getCharFrequencyMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        return map;
    }*/
}
