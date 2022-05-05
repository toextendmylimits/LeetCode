class Solution {   
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strings) {
            if(s.length() == 0) { continue; }
            
            int offset = s.charAt(0) - 'a';
            StringBuilder keySb = new StringBuilder();
            keySb.append('a');
            
            for(int i = 1; i < s.length(); i++) {
                char ch = (char)(s.charAt(i) - offset);
                if(ch < 'a') {
                    ch = (char)(ch + 26);
                }
                keySb.append(ch);
            }
            
            String key = keySb.toString();
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        
        List<List<String>> result = new ArrayList<>();
        for(List<String> list : map.values()) {
            result.add(list);
        }
        
        return result;
    }
}
