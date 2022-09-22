class Solution {
    // For open bracket, push into stack
    // For close bracket, if stack is empty, or popped element is not matched open bracket, return false
    // In the end, it's valid if stack is empty
    private static final Map<Character, Character> CLOSE_BRACKET_OPEN_BRACKET_MAP = new HashMap<>();
    static {
        CLOSE_BRACKET_OPEN_BRACKET_MAP.put(')', '(');
        CLOSE_BRACKET_OPEN_BRACKET_MAP.put(']', '[');
        CLOSE_BRACKET_OPEN_BRACKET_MAP.put('}', '{');
        //To add more
    }
    public boolean isValid(String s) {
         Deque<Character> stack = new ArrayDeque<>();
        for(int i  = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(CLOSE_BRACKET_OPEN_BRACKET_MAP.containsKey(ch)) {
                if(stack.isEmpty() || stack.pop() != CLOSE_BRACKET_OPEN_BRACKET_MAP.get(ch)) {
                    return false;
                }
            }
            else {
                stack.push(ch);
            }
        }
       
        return stack.isEmpty();
    }
}
