class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if(word == null || abbr == null) { return false; }
        
        int i = 0;
        int j = 0;
        while(i < word.length() && j < abbr.length()) {
            char ci = word.charAt(i);
            char cj = abbr.charAt(j);
            if(ci == cj) {
                i++;
                j++;
            }
            else if(Character.isDigit(cj) && cj != '0') {
                int skip = 0;
                while(j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    skip = skip * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                
                i += skip;
            }
            else {
                return false;
            }
        }
        
        return i == word.length() && j == abbr.length();
    }  
}
