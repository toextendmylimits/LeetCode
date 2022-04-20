class Solution {
    /*public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder reverseWord = new StringBuilder(word);
            reverseWord.reverse();
            if(i < words.length - 1) {
                reverseWord.append(" ");
            }
            result.append(reverseWord);
        }
        
        return result.toString();
    }*/

    public String reverseWords(String s) {
       char[] letters = s.toCharArray();
        
        int start = 0;
        for(int end = 0; end < letters.length; end++) {
            if(letters[end] == ' ') {
                reverse(letters, start, end - 1);
                start = end + 1;
            }
        }
        
        reverse(letters, start, letters.length - 1);
        
        return String.valueOf(letters);
    }  
    
    private char[] reverse(char[] letters, int start, int end) {
        while(start < end) {
            char temp = letters[start];
            letters[start] = letters[end];
            letters[end] = temp;
            start++;
            end--;
        }
        
        return letters;
    }
}
