class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            int correctPos = nums[i] - 1;
            if(nums[i] != nums[correctPos]) {
                swap(nums, i, correctPos);
            }
            else {
                i++;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for(i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                result.add(nums[i]);
            }
        }
        
        return result;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    // Approach 2
    /*public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for(int n : nums) {
            if(seen.contains(n)) {
                result.add(n);
            }
            else {
                seen.add(n);
            }
        }
        
        return result;
    }*/
    
    // Approach 3
    public List<Integer> findDuplicates(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) {
                result.add(nums[i]);
            }
        }
        
        return result;
    }        
}
