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
}
