class Solution {   
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strings) {
            if(s.length() == 0) { continue; }
            
            String key = getHashKey(s);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
    
    private String getHashKey(String s) {
        // Shift first letter to 'a', and then shift the maining letters same times
        StringBuilder result = new StringBuilder();
        
        int offset = s.charAt(0) - 'a';
        result.append('a');
        
         for(int i = 1; i < s.length(); i++) {
            char ch = (char)(s.charAt(i) - offset);
            if(ch < 'a') {
                ch = (char)(ch + 26);
            }
            result.append(ch);
        }
        
        return result.toString();
    }
}
