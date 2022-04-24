class Solution {
    public int calculate(String s) {
        char operator = '+';
        int currentNum = 0;
        int result = 0;
        int lastNum = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if(Character.isDigit(currentChar)) {
                currentNum = currentNum * 10 + (currentChar - '0');
            }
            
            if(!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == s.length() - 1) {
                if(operator == '+') {
                    result += lastNum;
                    lastNum = currentNum;
                }
                else if(operator == '-') {
                    result += lastNum;
                    lastNum = - currentNum;
                }
                else if(operator == '*') {
                    lastNum = lastNum * currentNum;
                }
                else if(operator == '/') {
                    lastNum = lastNum / currentNum;
                }
                
                operator = currentChar;
                currentNum = 0;
            }
        }
        
        result += lastNum;
        
        return result;
    }
    
    /*public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char operator = '+';
        int currentNum = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if(Character.isDigit(currentChar)) {
                currentNum = currentNum * 10 + (currentChar - '0');
            }
            
            if(!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == s.length() - 1) {
                if(operator == '+') {
                    stack.push(currentNum);
                }
                else if(operator == '-') {
                    stack.push(-currentNum);
                }
                else if(operator == '*') {
                    stack.push(stack.pop() * currentNum);
                }
                else if(operator == '/') {
                    stack.push(stack.pop() / currentNum);
                }
                
                operator = currentChar;
                currentNum = 0;
            }
        }
        
        int result = 0;
        while(!stack.isEmpty()) {
            result += stack.pop();
        }
        
        return result;
    }*/
}
