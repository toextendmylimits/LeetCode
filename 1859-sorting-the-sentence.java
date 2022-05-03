class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] newWords = new String[words.length];
        for(String word : words) {
            int pos = word.charAt(word.length() - 1) - '0' - 1;
            newWords[pos] = word.substring(0, word.length() - 1);
        }
        
        /*StringBuilder result = new StringBuilder();
        for(int i = 0; i < newWords.length - 1; i++) {
            result.append(newWords[i]);
            result.append(" ");
        }
        result.append(newWords[newWords.length - 1]);
        
        return result.toString();*/
        
        return String.join(" ", newWords);
    }
}
