class Solution {
    
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        for(int len1 = 1; len1 <= 3; len1++) {
            for(int len2 = 1; len2 <= 3; len2++) {
                for(int len3 = 1; len3 <= 3; len3++) {
                    int len4 = s.length() - len1 - len2 - len3;
                    if(len4 > 0 && len4 <= 3) {
                        String part1 = s.substring(0, len1);
                        String part2 = s.substring(len1, len1 + len2);
                        String part3 = s.substring(len1 + len2, len1 + len2 + len3); 
                        String part4 = s.substring(len1 + len2 + len3, len1 + len2 + len3 + len4);
                        if(isValidIpv4Part(part1) && isValidIpv4Part(part2) && isValidIpv4Part(part3) && isValidIpv4Part(part4)) {
     
                            result.add(String.join(".", new String[] { part1, part2, part3, part4}));
                        }
                    }

                }
            }
        }
        
        return result;
    }
    
    private boolean isValidIpv4Part(String part) {
        if(part == null || part.length() == 0) {
            return false;
        }
        
        if(part.length() > 1 && part.charAt(0) == '0') {
            return false;
        }
        
        try {
            if(Integer.parseInt(part) > 255) {
                return false;
            }
        }
        catch(Exception e) {
            return false;
        }
        
        return true;
    }
}
