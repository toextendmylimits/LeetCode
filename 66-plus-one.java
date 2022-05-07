class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 0;
        for(int i = n - 1; i >= 0; i--) {
            int sum = digits[i] + 1;
            digits[i] = sum % 10;
            carry = sum / 10;
            
            if(carry == 0) {
                return digits;
            }
        }
        
        digits = new int[n + 1];
        digits[0] = 1;
        
        return digits;
    }
}
