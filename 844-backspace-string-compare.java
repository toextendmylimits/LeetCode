class Solution {
    public boolean backspaceCompare(String s, String t) {
        int index1 = s.length() - 1;
        int index2 = t.length() - 1;
        while(index1 >= 0 || index2 >= 0) {
            int nextIndex1 = getNextValidCharIndex(s, index1);
            int nextIndex2 = getNextValidCharIndex(t, index2);
            if(nextIndex1 < 0 && nextIndex2 < 0) {
                return true;
            }
            
            if(nextIndex1 < 0 || nextIndex2 < 0) {
                return false;
            }
            
            if(s.charAt(nextIndex1) != t.charAt(nextIndex2)) {
                return false;
            }
            
            index1 = nextIndex1 - 1;
            index2 = nextIndex2 - 1;
        }
        
        return true;
    }
    
    private int getNextValidCharIndex(String s, int index) {
        int backspaces = 0;
        while(index >= 0) {
            if(s.charAt(index) == '#') {
                backspaces++;
            }
            else if(backspaces > 0) {
                backspaces--;
            }
            else {
                break;
            }
            
            index--;
        }
        
        return index;
    }
}
