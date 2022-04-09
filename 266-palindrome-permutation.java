class Solution {
    private static final int LETTERS_LENGTH = 26;
    public boolean canPermutePalindrome(String s) {
        int[] lettersFrequency = new int[LETTERS_LENGTH];
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            lettersFrequency[c - 'a']++;
        }
        
        int oddFrequency = 0;
        for(int f : lettersFrequency) {
            if(f % 2 == 1) {
                oddFrequency++;
            }
            
            if(oddFrequency > 1) {
                return false;
            }
        }
        
        return true;
    }
}
