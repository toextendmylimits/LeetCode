class Solution {
     public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            String[] partsA = a.split(" ", 2);
            String[] partsB = b.split(" ", 2);
            String idA = partsA[0];
            String contentA = partsA[1];
            String idB = partsB[0];
            String contentB = partsB[1];
            boolean isDigitA = Character.isDigit(contentA.charAt(0));
            boolean isDigitB = Character.isDigit(contentB.charAt(0));
            if(isDigitA && isDigitB) {
                return 0;
            }
            else if(!isDigitA && isDigitB) {
                return -1;
            }
            else if(isDigitA && !isDigitB) {
                return 1;
            }
            else {
                int compareContentResult = contentA.compareTo(contentB);
                if(compareContentResult == 0) {
                    return idA.compareTo(idB);
                }
                else {
                    return compareContentResult;
                }
            }
        });
         
         return logs;
    }
    
    /*public String[] reorderLogFiles(String[] logs) {
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
        
        return concatLetterDigitLogListsToArray(letterLogs, digitLogs);
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
    
    private String[] concatLetterDigitLogListsToArray(List<String> letterLogs, List<String> digitLogs) {
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
    }*/
}
