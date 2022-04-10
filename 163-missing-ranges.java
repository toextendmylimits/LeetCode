class Solution {
    private static final String RANGE_FORMAT_SEPARATOR = "->";
    
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if(nums.length == 0) {
            result.add(formatRange(lower, upper));
            return result;
        }
        
        // Edge case first element greater than lower
        int first = nums[0];
        if(first > lower) {
            result.add(formatRange(lower, first - 1));
        }
        
        // Loop through first to second to last, and compare to its next
        for(int i = 0; i <= nums.length - 2; i++) {
            if(nums[i] + 1 < nums[i + 1]) {
                result.add(formatRange(nums[i] + 1, nums[i + 1] - 1));
            }

        }
        
        // Edge case, last element less than upper
        int last = nums[nums.length - 1];
        if(last < upper) {
            result.add(formatRange(last + 1, upper));
        }
        
        return result;
    }
    
    private String formatRange(int lower, int upper) {
        if(lower == upper) {
            return String.valueOf(lower);
        }
        
        return lower + RANGE_FORMAT_SEPARATOR + upper;
    }
}
