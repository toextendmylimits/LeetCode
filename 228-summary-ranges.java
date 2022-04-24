class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        
        int start = 0;
        for(int end = 0; end < nums.length; end++) {
            if(end + 1 < nums.length && nums[end + 1] == nums[end] + 1) {
                continue;
            }
            
            result.add(formatRange(nums[start], nums[end]));
            start = end + 1;
        }
        
        
        return result;
    }
    
    private String formatRange(int start, int end) {
        if(start == end) {
            return String.valueOf(start);
        }
        
        return start + "->" + end;
    }
}
