class Solution {
    private static Map<Character, String> phoneLetters = Map.of('2', "abc", 
                                                                '3', "def", 
                                                                '4', "ghi", 
                                                                '5', "jkl", 
                                                                 '6', "mno", 
                                                                '7', "pqrs", 
                                                                '8', "tuv", 
                                                                '9', "wxyz");
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) {
            return result;
        }
        
        backtrack(digits, new StringBuilder(), result);
        return result;
    }
    
    private void backtrack(String digits, StringBuilder path, List<String> result) {
        if(path.length() == digits.length()) {
            result.add(path.toString());
            return;
        }
        
        char nextDigit = digits.charAt(path.length());
        for(char letter : phoneLetters.get(nextDigit).toCharArray()) {
            path.append(letter);
            backtrack(digits, path, result);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
