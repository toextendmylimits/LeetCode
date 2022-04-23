class Solution {
    private static final Map<Character, Character> bracketMap = new HashMap<>();
    static {
        bracketMap.put(')','(');
        bracketMap.put('}','{');
        bracketMap.put(']','[');
    }
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(stack.isEmpty()) {
                stack.add(c);
            }
            else {
                if(stack.peek() == bracketMap.get(c)) {
                    stack.pop();
                }
                else {
                    stack.add(c);
                }
            }
        }
        
        return stack.isEmpty();
    }
}
