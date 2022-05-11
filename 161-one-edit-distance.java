class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null) { return false; }
        
        int shortLen = s.length();
        int longLen = t.length();
        if(shortLen > longLen) {
            return isOneEditDistance(t, s);
        }
        
        for(int i = 0; i < shortLen; i++) {
            if(s.charAt(i) != t.charAt(i)) {
                if(shortLen == longLen) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
                else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        
        return longLen - shortLen == 1;
    }
}
