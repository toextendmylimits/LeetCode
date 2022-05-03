class Solution {
    static int[] ROMAN_VALUES = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    static String[] ROMAN_SYMBOLS = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
    
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < ROMAN_VALUES.length && num > 0; i++) {
            while(num >= ROMAN_VALUES[i]) {
                result.append(ROMAN_SYMBOLS[i]);
                num -= ROMAN_VALUES[i];
            }
        }
        
        return result.toString();
    }
}
