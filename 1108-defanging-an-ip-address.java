class Solution {
    /*public String defangIPaddr(String address) {
        String[] parts = address.split("\\.");
        return String.join("[.]", parts);
    }*/
    
    public String defangIPaddr(String address) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < address.length(); i++) {
            char c = address.charAt(i);
            if(c == '.') {
                result.append("[.]");
            }
            else {
                result.append(c);
            }
        }
        
        return result.toString();
    }    
}
