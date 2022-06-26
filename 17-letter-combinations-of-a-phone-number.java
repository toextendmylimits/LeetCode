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
        
        backtrack(digits, new ArrayList<Character>(), result);
        return result;
    }
    
    private void backtrack(String digits, List<Character> path, List<String> result) {
        if(path.size() == digits.length()) {
            String combination = path.stream()
                .map(c->c.toString())
                .collect(Collectors.joining(""));
            result.add(combination);
            return;
        }
        
        char nextDigit = digits.charAt(path.size());
        for(char letter : phoneLetters.get(nextDigit).toCharArray()) {
            path.add(letter);
            backtrack(digits, path, result);
            path.remove(path.size() - 1);
        }
    }
}
