class Solution {
    private static final int INDEX_NOT_EXIST = -1;
    
    public boolean isIsomorphic(String s, String t) {
       if(s == null || t == null) { return false; }
        
        if(s.length() != t.length()) { return false; }
      
        Map<Character, Integer> indexMappingS = new HashMap<>();
        Map<Character, Integer> indexMappingT = new HashMap<>();
      
        for(int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            int firstIndexOfCharS = indexMappingS.getOrDefault(charS, INDEX_NOT_EXIST);
            int firstIndexOfCharT = indexMappingT.getOrDefault(charT, INDEX_NOT_EXIST);
            if(firstIndexOfCharS != firstIndexOfCharT) {
                return false;
            }
            
            if(firstIndexOfCharS == INDEX_NOT_EXIST) {
                indexMappingS.put(charS, i);
                indexMappingT.put(charT, i);
            }
        }
    
       return true;
    }
}
