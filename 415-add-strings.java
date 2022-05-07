class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        StringBuilder result = new StringBuilder();
        
        int carry = 0;
        for(int i = 0; i < len1 || i < len2; i++) {
            int val1 = i < len1? num1.charAt(len1 - 1 - i) - '0' : 0;
            int val2 = i < len2? num2.charAt(len2 - 1 - i) - '0' : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            result.append(sum % 10);
        }
        
        if(carry > 0) {
            result.append(carry);
        }
        
        return result.reverse().toString();
    }
}
