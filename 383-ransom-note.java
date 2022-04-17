class Solution {
    /*public static final int LOWER_CASE_LETTERS_COUNT = 26;
    public static final char SMALLEST_LOWER_CASE_LETTER = 'a';
    
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letterFrequency = new int[LOWER_CASE_LETTERS_COUNT];
        for(int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            letterFrequency[getLowercaseLetterIndex(c)]++; 
        }
        
        for(int i = 0; i < ransomNote.length(); i++) {
            char noteChar = ransomNote.charAt(i);
            int index = getLowercaseLetterIndex(noteChar);
            if(letterFrequency[index] == 0) {
                return false;
            }
            else {
               letterFrequency[index]--; 
            }
        }
        
        return true;
    }
    
    private int getLowercaseLetterIndex(char c) {
        return c - SMALLEST_LOWER_CASE_LETTER;
    }*/
    
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) {
            return false;
        }
        
        Map<Character, Integer> charFrequencyMap = getCharFrequencyMap(magazine);
        
        for(int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            int frequency = charFrequencyMap.getOrDefault(c, 0);
            if(frequency == 0) {
                return false;
            }
            charFrequencyMap.put(c, frequency - 1);
        }
        
        return true;
    } 
    
    private Map<Character, Integer> getCharFrequencyMap(String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        return map;
    }
}
