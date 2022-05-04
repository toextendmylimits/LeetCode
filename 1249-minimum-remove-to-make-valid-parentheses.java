class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> indexesToRemove = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);          
            if(ch == '(') {
                stack.push(i);
            }
            else if(ch == ')') {
                if(stack.isEmpty()) {
                    indexesToRemove.add(i);
                }
                else {
                    stack.pop();
                }
            }
        }
        
        while(!stack.isEmpty()) {
            indexesToRemove.add(stack.pop());
        }
        
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(!indexesToRemove.contains(i)) {
                result.append(s.charAt(i));
            }
        }
        
        return result.toString();
    }
}
