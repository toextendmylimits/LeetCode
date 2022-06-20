class Solution {
     public boolean backspaceCompare(String s, String t) {
        int p1 = s.length() - 1;
         int p2 = t.length() - 1;
         int backspaces1 = 0; // Represent remaining number of backspace operations for s
         int backspaces2 = 0; // Represent remaining number of backspace operations for t
         while(p1 >= 0 || p2 >= 0) {
             while(p1 >= 0 &&(s.charAt(p1) == '#' || backspaces1 != 0)) {
                 if(s.charAt(p1) == '#') { backspaces1++; }
                 else { backspaces1--; }
                 p1--;
             }
             
             while(p2 >= 0 &&(t.charAt(p2) == '#' || backspaces2 != 0)) {
                 if(t.charAt(p2) == '#') { backspaces2++; }
                 else { backspaces2--; }
                 p2--;
             } 
             
             if(p1 < 0 && p2 < 0) { return true; }
             if(p1 < 0 || p2 < 0) { return false; }
             if(s.charAt(p1) == t.charAt(p2)) {
                 p1--;
                 p2--;
             }
             else {
                 return false;
             }
         }
         
         return true;
    }   
    /*public boolean backspaceCompare(String s, String t) {
        return backspace(s).equals(backspace(t));    
    }*/
    
    /*private String backspace(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()) {
            if(c != '#') {
                stack.push(c);
            }
            else if(!stack.isEmpty()) {
                stack.pop();
            }
        }
        
        return String.valueOf(stack);
    }*/
    
    private String backspace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(c != '#') {
                stringBuilder.append(c);
            }
            else if(stringBuilder.length() > 0) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
        
        return stringBuilder.toString();
    }    
}
