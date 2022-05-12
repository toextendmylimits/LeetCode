class Solution {

    public String validIPAddress(String queryIP) {
        if(isIpv4(queryIP)) {
            return "IPv4";
        }
        
        if(isIpv6(queryIP)) {
            return "IPv6";
        }
        
        return "Neither";
    }
    
    private boolean isIpv6(String s) {
        String[] parts = s.split(":", -1);
        if(parts.length != 8) {
            return false;
        }
        
        for(int i = 0; i < parts.length; i++) {
            if(!isIpv6Part(parts[i])) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isIpv6Part(String s) {      
        if(s == null || s.isEmpty() || s.length() > 4) { return false; }
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)) {
                if(Character.isLetter(c)) {
                    char uppercaseLetter = Character.toUpperCase(c);
                    if(uppercaseLetter < 'A' || uppercaseLetter > 'F') {
                        return false;
                    }
                }
            }
           else {
               return false;
           }
        }  
           
       return true;
    }
    
    private boolean isIpv4(String ip) {
       String[] parts = ip.split("\\.", -1);
        if(parts.length != 4) {
            return false;
        }
        
        for(int i = 0; i < parts.length; i++) {
            if(!isIpv4Part(parts[i])) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isIpv4Part(String s) {
        if(s == null || s.isEmpty() || s.length() > 3) { return false; }    

        if(s.length() > 1 && s.charAt(0) == '0') { return false; }
  
        try {
            int value = Integer.parseInt(s);
            return value >= 0 && value <= 255;
        }
        catch(NumberFormatException e) {
            return false;
        }
    }
}
