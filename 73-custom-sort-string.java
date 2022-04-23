class Solution {
    private static final int LETTERS_COUNT = 26;
    private static final char START_LETTER = 'a';
    
    public String customSortString(String order, String s) {
        StringBuilder result = new StringBuilder();
        int[] charCount = getCharCountArray(s);
        
        appendLettersAsOrder(order, charCount, result);
        
        appendRemaingLetters(charCount, result);
        
        return result.toString();
    }
    
    private int getIndexOfChar(char c) {
        return c - START_LETTER;
    }
    
    private int getCharCodeAtIndex(int i) {
        return i + START_LETTER;
    }
    
    private int[] getCharCountArray(String s) {
        int[] charCount = new int[LETTERS_COUNT];
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCount[getIndexOfChar(c)]++;
        }
        
        return charCount;
    }
    
    private void appendRemaingLetters(int[] charCount, StringBuilder result) {
        for(int i = 0; i < LETTERS_COUNT; i++) {
            for(int j = 0; j < charCount[i]; j++) {
                int charCode = getCharCodeAtIndex(i);
                result.append((char) charCode);
            }
        }
    }
    
    private void appendLettersAsOrder(String order, int[] charCount, StringBuilder result) {
        for(int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            while(charCount[getIndexOfChar(c)]-- > 0) {
                result.append(c);
            }
        }
    }
    
    /*public String customSortString(String order, String s) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        for(int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            charIndexMap.put(c, i);
        }
        
        Character[] charArrayOfS = new Character[s.length()];
        
        for(int i = 0; i < s.length(); i++) {
            charArrayOfS[i] = s.charAt(i);
        }
        Arrays.sort(charArrayOfS, (a, b) -> {
            if(charIndexMap.containsKey(a) && charIndexMap.containsKey(b)) {
                return charIndexMap.get(a) - charIndexMap.get(b);
            }
            else if(charIndexMap.containsKey(a)) {
                return -1;
            }
            else if(charIndexMap.containsKey(b)) {
                return 1;
            }
            else {
                return 0;
            }
        });
        
        StringBuilder result = new StringBuilder();
        for(Character c : charArrayOfS) {
            result.append(c);
        }
        
        return result.toString();
    }*/
}
