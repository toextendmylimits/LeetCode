class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();
        
        for(String part : parts) {
            switch(part) {
                case ".":
                case "":
                    break;
                
                case "..":
                    if(!stack.isEmpty()) { stack.pop(); }
                    break;
                    
                default:
                    stack.push(part);
                    break;
            }
        }
        
        if(stack.isEmpty()) {
            return "/";
        }
        
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) {
            result.insert(0, stack.pop()).insert(0, "/");
        }
        
        return result.toString();
    }
}
