class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> stringStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int currentNum = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 
            if(Character.isDigit(c)) {
                currentNum = currentNum * 10 + (c - '0');
            }
            else if(c == '[') {
                countStack.push(currentNum);
                stringStack.push(currentString);
                
                currentNum = 0;
                currentString = new StringBuilder();
            }
            else if(c == ']') {
                StringBuilder decodedString = stringStack.pop();
                for(int count = countStack.pop(); count > 0; count--) {
                    decodedString.append(currentString);
                }
                
                currentString = decodedString;
            }
            else {
                currentString.append(c);
            }
        }
        
        return currentString.toString();
    }
    
    /*public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 
            if(c == ']') {
                List<Character> decodedString = new ArrayList<>();
                while(stack.peek() != '[') {
                    decodedString.add(stack.pop());
                }
                
                stack.pop(); 
                
                int num = 0;
                int mulitplier = 1;
                
                while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    num += mulitplier * (stack.pop() - '0');
                    mulitplier *= 10;
                }
                
                while(num > 0) {
                    for(int j = decodedString.size() - 1; j >= 0; j--) {
                        stack.push(decodedString.get(j));
                    }
                    
                    num--;
                }
            }
            else {
                stack.push(c);
            }
        }
        
        // Result
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        
        return result.toString();
    }*/
}
