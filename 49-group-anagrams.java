class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            String key = getHashKey(s);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
    
    /*private String getHashKey(String s) {
        char[] letters = s.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }*/
    
    private String getHashKey(String s) {
        int[] charCounts = new int[26];
        for(int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
        }
        
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < charCounts.length; i++) {
            result.append((char)(i + 'a'));
            result.append(charCounts[i]);
        }
        return result.toString();
    }    
}
