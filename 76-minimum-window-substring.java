class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length()) { return ""; }    
        
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char c : t.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int matches = 0;
        
        int left = 0;
        for(int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            if(freqMap.containsKey(rightChar)) {
                freqMap.put(rightChar, freqMap.get(rightChar) - 1);
                if(freqMap.get(rightChar) >= 0) {
                    matches++;
                }                
            }
            
            while(matches == t.length()) {
                int currentLen = right - left + 1;
                if(currentLen < minLen) {
                    minLen = currentLen;
                    start = left;
                }
                
                char leftChar = s.charAt(left);
                if(freqMap.containsKey(leftChar)) {
                    if(freqMap.get(leftChar) == 0) {
                        matches--;
                    }
                    
                    freqMap.put(leftChar, freqMap.get(leftChar) + 1);
                }
                
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE? "" : s.substring(start, start + minLen);
    }
}
