class Solution {
    static final Map<Character, Integer> ROMAN_LETTER_VALUE_MAP = new HashMap<>();
    static {
        ROMAN_LETTER_VALUE_MAP.put('I', 1);
        ROMAN_LETTER_VALUE_MAP.put('V', 5);
        ROMAN_LETTER_VALUE_MAP.put('X', 10);
        ROMAN_LETTER_VALUE_MAP.put('L', 50);
        ROMAN_LETTER_VALUE_MAP.put('C', 100);
        ROMAN_LETTER_VALUE_MAP.put('D', 500);
        ROMAN_LETTER_VALUE_MAP.put('M', 1000);
    }
    
    public int romanToInt(String s) {
        int sum = 0;
        for(int i = 0; i < s.length() - 1; i++) {
            int current = ROMAN_LETTER_VALUE_MAP.get(s.charAt(i));
            int next = ROMAN_LETTER_VALUE_MAP.get(s.charAt(i + 1));
            
            sum += current < next? -current : current;
        }
        
        sum += ROMAN_LETTER_VALUE_MAP.get(s.charAt(s.length() - 1));
        
        return sum;
    }
}
