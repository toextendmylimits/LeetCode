class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int len1 = a.length();
        int len2 = b.length();
        
        int carry = 0;
        for(int i = 0; i < len1 || i < len2; i++) {
            int val1 = i < len1 && a.charAt(len1 - 1 - i) == '1'? 1 : 0;
            int val2 = i < len2 && b.charAt(len2 - 1 - i) == '1'? 1 : 0;
            int sum = val1 + val2 + carry;
            result.append(sum % 2);
            carry = sum / 2;
        }
        
        if(carry > 0) {
            result.append(carry);
        }
        
        return result.reverse().toString();
    }
}
