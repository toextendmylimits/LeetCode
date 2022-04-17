class Solution {
    /*public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char charOfS = s.charAt(i);
            char charOfT = t.charAt(i);
            charFrequencyMap.put(charOfS, charFrequencyMap.getOrDefault(charOfS, 0) + 1) ;
            charFrequencyMap.put(charOfT, charFrequencyMap.getOrDefault(charOfT, 0) - 1) ;
        }
        
        for(int j : charFrequencyMap.values()) {
            if(j != 0) {
                return false;
            }
        }
        
        return true;
    }*/
    
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        
        int[] charFrequency = new int[26];
        for(int i = 0; i < s.length(); i++) {
            charFrequency[s.charAt(i) - 'a']++;
            charFrequency[t.charAt(i) - 'a']--;
        }
        
        for(int j : charFrequency) {
            if(j != 0) {
                return false;
            }
        }
        
        return true;
    }    

}
