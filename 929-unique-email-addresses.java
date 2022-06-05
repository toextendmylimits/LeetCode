class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for(String email : emails) {
            String[] parts = email.split("@");
            if(parts.length == 2) {
                String localName = parts[0];
                String domainName = parts[1];
                StringBuilder cleanLocalName = new StringBuilder();
                for(char c : localName.toCharArray()) {
                    if(c == '+') {
                        break;
                    }
                    else if(c == '.') {
                        continue;
                    }
                    else {
                        cleanLocalName.append(c);
                    }
                }
                String cleanEmail = cleanLocalName.toString() + "@" + domainName;
                if(!uniqueEmails.contains(cleanEmail)) {
                    uniqueEmails.add(cleanEmail);
                }
            }
        }
        
        return uniqueEmails.size();
    }
}
