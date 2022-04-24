class Solution {
    /*private static final String KEYBOARD_ROW_1_LETTERS = "qwertyuiop";
    private static final String KEYBOARD_ROW_2_LETTERS = "asdfghjkl";
    private static final String KEYBOARD_ROW_3_LETTERS = "zxcvbnm";
    
    public String[] findWords(String[] words) {
        Set<Character> row1 = convertStringToSet(KEYBOARD_ROW_1_LETTERS);
        Set<Character> row2 = convertStringToSet(KEYBOARD_ROW_2_LETTERS);
        Set<Character> row3 = convertStringToSet(KEYBOARD_ROW_3_LETTERS);
        
        List<String> result = new ArrayList<>();
        for(String word: words) {
            String lowercaseWord = word.toLowerCase();
            Set<Character> setOfWord = convertStringToSet(lowercaseWord);
            if(row1.containsAll(setOfWord) || row2.containsAll(setOfWord) || row3.containsAll(setOfWord)) {
                result.add(word);
            }
        }
        
        return result.toArray(new String[result.size()]);
    }
    
    private Set<Character> convertStringToSet(String s) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!set.contains(c)) {
                set.add(c);
            }
        }
        
        return set;
    }*/
    
    private final static Map<Character, Integer> LETTER_ROW_MAP = new HashMap<>();
    static {
        for(char c : "qwertyuiop".toCharArray()) {
            LETTER_ROW_MAP.put(c, 1);
        }
        
        for(char c : "asdfghjkl".toCharArray()) {
            LETTER_ROW_MAP.put(c, 2);
        }
        
        for(char c : "zxcvbnm".toCharArray()) {
            LETTER_ROW_MAP.put(c, 3);
        }
    }
    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        for(String word: words) {
            if(canBeTypedByLettersOfOneRow(word.toLowerCase())) {
                result.add(word);
            }
        }
        
        return result.toArray(new String[result.size()]);
    }
    
    private boolean canBeTypedByLettersOfOneRow(String word) {
        boolean useLettersOfRow1 = false;
        boolean useLettersOfRow2 = false;
        boolean useLettersOfRow3 = false;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int row = LETTER_ROW_MAP.getOrDefault(c, 0);
            if(row == 1) {
               useLettersOfRow1 = true;
            }
            else if(row == 2) {
                useLettersOfRow2 = true;
            }
            else if(row == 3) {
                useLettersOfRow3 = true;
            }
            
            if((useLettersOfRow1 && useLettersOfRow2) || (useLettersOfRow1 && useLettersOfRow3) || (useLettersOfRow2 && useLettersOfRow3)) {
                return false;
            }
        }
        
        return true;
    }
}
