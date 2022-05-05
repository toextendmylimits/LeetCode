class Solution {
    /*public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        
        return i == s.length();
    }*/
    
    public boolean isSubsequence(String s, String t) {
        List<Integer>[] indexes = new ArrayList[256];
        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if(indexes[ch] == null) {
                indexes[ch] = new ArrayList<>();
            }
            indexes[ch].add(i);
        }
        
        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(indexes[ch] == null) { return false; }
            
            int pos = binarySearch(indexes[ch], j);
            if(pos == indexes[ch].size()) { return false; } 
            
            j = indexes[ch].get(pos) + 1;
        }
        
        return true;
    }
    
    private int binarySearch(List<Integer> nums, int target) {
        int low = 0;
        int high = nums.size();
        while(low < high) {
            int middle = low + (high - low) / 2;
            if(nums.get(middle) >= target) {
                high = middle;
            }
            else{
                low = middle + 1;
            }
        }
        
        return low;
    }
}
