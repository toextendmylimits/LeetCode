/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    private static final int MAX_GUESSES = 10;
    private static final int WORD_LENGTH = 6;
    private static final String GUESSED_CORRECT_MESSAGE = "You guessed the secret word correctly.";
    
    public void findSecretWord(String[] wordlist, Master master) {
        Random random = new Random();
        for(int i = 0, matches = 0; i < MAX_GUESSES && matches < WORD_LENGTH; i++) {
            int randomIndex = random.nextInt(wordlist.length);
            String randomWord = wordlist[randomIndex];
            matches = master.guess(randomWord);
            
            if(matches == WORD_LENGTH) {
                System.out.println(GUESSED_CORRECT_MESSAGE);
                return;
            }
            
            List<String> candidates = new ArrayList<>();
            for(String word : wordlist) {
                if(matches == getMatches(randomWord, word)) {
                    candidates.add(word);
                }
            }
            wordlist = candidates.toArray(String[]::new);
        }
    }
    
    private int getMatches(String word1, String word2) {
        int matches = 0;
        for(int i = 0; i < WORD_LENGTH; i++) {
            if(word1.charAt(i) == word2.charAt(i)) {
                matches++;
            }
        }
        
        return matches;
    }
}
