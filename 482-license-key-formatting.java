class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if(ch != '-') {
                result.append(Character.toUpperCase(ch));
                count++;
                if(count % k == 0) {
                    result.append('-');
                }
            }
        }
        
        // Remove white space at end
        for(int i = result.length() - 1; i >= 0 && result.charAt(i) == '-'; i--) {
            result.deleteCharAt(i);
        }
        
        return result.reverse().toString();
    }
}
