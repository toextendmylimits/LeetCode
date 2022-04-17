class Solution {
    public static final int LOWER_CASE_LETTERS_COUNT = 26;
    public static final char SMALLEST_LOWER_CASE_LETTER = 'a';
    
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letterFrequency = new int[LOWER_CASE_LETTERS_COUNT];
        for(int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            letterFrequency[getLowerLetterIndex(c)]++; 
        }
        
        for(int i = 0; i < ransomNote.length(); i++) {
            char noteChar = ransomNote.charAt(i);
            int index = getLowerLetterIndex(noteChar);
            if(letterFrequency[index] == 0) {
                return false;
            }
            else {
               letterFrequency[index]--; 
            }
        }
        
        return true;
    }
    
    private int getLowerLetterIndex(char c) {
        return c - SMALLEST_LOWER_CASE_LETTER;
    }
}
