class Solution {
    private static final Map<Character, Integer> ROMAN_LETTER_VALUE = new HashMap<>();
    static {
        ROMAN_LETTER_VALUE.put('I', 1);
        // To add more
        ROMAN_LETTER_VALUE.put('V', 5);
        ROMAN_LETTER_VALUE.put('X', 10);
        ROMAN_LETTER_VALUE.put('L', 50);
        ROMAN_LETTER_VALUE.put('C', 100);
        ROMAN_LETTER_VALUE.put('D', 500);
        ROMAN_LETTER_VALUE.put('M', 1000);
    }
    
    public int romanToInt(String s) {
       int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            int value = ROMAN_LETTER_VALUE.get(s.charAt(i));
            boolean smallerThanNextDigit = i + 1 < s.length() && value < ROMAN_LETTER_VALUE.get(s.charAt(i + 1));
            sum += smallerThanNextDigit? -value : value;
        }
        
        return sum;
    }
}
