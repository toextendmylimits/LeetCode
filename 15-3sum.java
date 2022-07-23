class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || nums[i] != nums[i - 1]) {
                int targetSum = -nums[i];
                int left = i + 1;
                int right = nums.length - 1;
                while(left < right) {
                    int currTwoSum = nums[left] + nums[right];
                    if(currTwoSum > targetSum) {
                        right--;
                    }
                    else if(currTwoSum < targetSum) {
                        left++;
                    }
                    else {
                        result.add(List.of(nums[i], nums[left], nums[right]));
                        left++;
                        right--;
                        while(left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while(left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
            }
        }
        
        return result;
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if(i == 0 || nums[i] != nums[i - 1]) {
                twoSum(nums, i, result);
            }   
        }
        
        return result;
    }
    
    /*public void twoSum(int[] nums, int i, List<List<Integer>> result) {
        int left = i + 1;
        int right = nums.length - 1;
        while(left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if(sum < 0) {
                left++;
            }
            else if(sum > 0) {
                right--;
            }
            else {
                result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                left++;
                right--;
                while(left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
            }
        }
    }*/
    public void twoSum(int[] nums, int i, List<List<Integer>> result) {
        Set<Integer> seen = new HashSet<>();
        for(int j = i + 1; j < nums.length; j++) {
            int complement = - nums[i] - nums[j];
            if(seen.contains(complement)) {
                result.add(Arrays.asList(nums[i], nums[j], complement));
                while(j + 1 < nums.length && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            
            seen.add(nums[j]);
        }
    }    
}
