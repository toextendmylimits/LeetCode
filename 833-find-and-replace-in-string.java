class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        List<int[]> indexList = new ArrayList<>();
        for(int i = 0; i < indices.length; i++) {
            indexList.add(new int[] { indices[i], i });           
        }
        
        Collections.sort(indexList, (a, b) -> a[0] - b[0]);
        
        StringBuilder resultSb = new StringBuilder();
        int lastPosition = 0;
        for(int[] indexArr : indexList) {
            int startIndex = indexArr[0];
            int sourceIndex = indexArr[1];
            String source = sources[sourceIndex];
            
            int potentialNewPosition = startIndex + source.length();
            if(potentialNewPosition <= s.length() && s.substring(startIndex, potentialNewPosition).equals(source)) {
                resultSb.append(s.substring(lastPosition, startIndex));
                resultSb.append(targets[sourceIndex]);
                lastPosition = potentialNewPosition;
            }
        }
             
        if(lastPosition < s.length()) {
            resultSb.append(s.substring(lastPosition));
        }
        return resultSb.toString();
    }
    
}
