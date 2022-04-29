class Solution {
     public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char charEnd = s.charAt(windowEnd);
            if(charIndexMap.containsKey(charEnd)) {
                windowStart = Math.max(windowStart, charIndexMap.get(charEnd) + 1);
            }
            
            charIndexMap.put(charEnd, windowEnd);
            
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        
        return maxLength;
    }
    
    /*public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int windowStart = 0;
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char charEnd = s.charAt(windowEnd);
            frequencyMap.put(charEnd, frequencyMap.getOrDefault(charEnd, 0) + 1);
            
            while(frequencyMap.getOrDefault(charEnd, 0) > 1) {
                char charStart = s.charAt(windowStart);
                frequencyMap.put(charStart, frequencyMap.getOrDefault(charStart, 0) - 1);
                windowStart++;
            }
            
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        
        return maxLength;
    }*/
}
