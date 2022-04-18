class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();
        
        for(String log : logs) {
            if(isLetterLog(log)) {
               letterLogs.add(log);
            }
            else {
                digitLogs.add(log);
            }
        }
        
        letterLogs.sort(getLetterLogComparator());
        
        return concatLetterDigitListsToArray(letterLogs, digitLogs);
    }
    
    private Comparator<String> getLetterLogComparator() {
        return (a, b) -> {
            String[] wordsA = getLogIdAndContent(a);
            String idA = wordsA[0];
            String contentA = wordsA[1];
            String[] wordsB = getLogIdAndContent(b);
            String idB = wordsB[0];
            String contentB = wordsB[1];
            
            if(contentA.equals(contentB)) {
                return idA.compareTo(idB);
            }
            else {
                return contentA.compareTo(contentB);
            }
        };
    }
    
    private String[] concatLetterDigitListsToArray(List<String> letterLogs, List<String> digitLogs) {
        String[] result = new String[letterLogs.size() + digitLogs.size()];
        int i = 0;
        for(; i < letterLogs.size(); i++) {
            result[i] = letterLogs.get(i);
        }
        
        for(i = 0; i < digitLogs.size(); i++) {
            result[letterLogs.size() + i] = digitLogs.get(i);
        }
        
        return result;
    }
    
    private boolean isLetterLog(String log) {
        int firstSpaceIndex = getFirstSpaceIndex(log);

        char fistCharOfContent = log.substring(firstSpaceIndex + 1, firstSpaceIndex + 2).charAt(0);
        return !Character.isDigit(fistCharOfContent);

    }
    
    private String[] getLogIdAndContent(String log) {
        int firstSpaceIndex = getFirstSpaceIndex(log);
        
        return new String[] { log.substring(0, firstSpaceIndex), log.substring(firstSpaceIndex + 1, log.length()) };
    }
    
    private int getFirstSpaceIndex(String log) {
        return log.indexOf(" ");
    }
}
