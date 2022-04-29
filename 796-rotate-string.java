class Solution {
    public boolean rotateString(String s, String goal) {
        if(s == null || goal == null) {
            return false;
        }
        
        if(s.length() != goal.length()) {
            return false;
        }
        
        if(s.length() == 0) {
            return true;
        }
        
        for(int i = 0; i < s.length(); i++) {
            for(int rotation = 1; rotation <= s.length(); rotation++) {
                if(isSameAfterRotation(s, goal, rotation)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean isSameAfterRotation(String s, String goal, int rotation) {
        for(int i = 0; i < s.length(); i++) {
            int indexAfterRotation = (i + rotation) % goal.length();
            if(s.charAt(i) != goal.charAt(indexAfterRotation)) {
                return false;
            }
        }
        
        return true;
    }
}
