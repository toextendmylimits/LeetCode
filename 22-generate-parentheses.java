class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder track = new StringBuilder();
        
        backtrack(0, 0, n, track, result);
        
        return result;
    }
    
    private void backtrack(int open, int close, int max, StringBuilder track, List<String> result) {
        if(track.length() == max * 2) {
            result.add(track.toString());
            return;
        }
        
        if(open < max) {
            track.append('(');
            backtrack(open + 1, close, max, track, result);
            track.deleteCharAt(track.length() - 1);
        }
        
        if(close < open) {
            track.append(')');
            backtrack(open, close + 1, max, track, result);
            track.deleteCharAt(track.length() - 1);
        }
    }
}
