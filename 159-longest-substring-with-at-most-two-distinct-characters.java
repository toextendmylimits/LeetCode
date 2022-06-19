class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int maxLen = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        // Sliding window
        int start = 0;
        for(int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            freqMap.put(endChar, freqMap.getOrDefault(endChar, 0) + 1);
            while(freqMap.size() > 2) {
                char startChar = s.charAt(start);
                freqMap.put(startChar, freqMap.get(startChar) - 1);
                if(freqMap.get(startChar) == 0) {
                    freqMap.remove(startChar);
                }
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        
        return maxLen;
    }
    /*public int lengthOfLongestSubstringTwoDistinct(String s) {
        int maxLen = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        // Sliding window
        int start = 0;
        for(int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);

            if(charIndexMap.size() == 2 && !charIndexMap.containsKey(endChar)) {
                char startChar = s.charAt(start);
                int del_idx = Collections.min(charIndexMap.values());
                charIndexMap.remove(s.charAt(del_idx));
                start = del_idx + 1;
            }

            charIndexMap.put(endChar, end);
            maxLen = Math.max(maxLen, end - start + 1);
        }
        
        return maxLen;
    }*/    
}
