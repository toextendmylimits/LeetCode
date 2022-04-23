class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if(i == 0 || nums[i] != nums[i - 1]) {
               Set<Integer> seen = new HashSet<>();
                for(int j = i + 1; j < nums.length; j++) {
                    int complement = - nums[i] - nums[j];
                    if(seen.contains(complement)) {
                        result.add(Arrays.asList(nums[i], nums[j], complement));
                        while(j < nums.length - 1 && nums[j] == nums[j + 1]) {
                            j++;
                        }
                    }
                    seen.add(nums[j]);
                }
            }
        }
        
        return result;
    }
    
    /*public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if(i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1;
                int high = nums.length - 1;
                while(low < high) {
                    int sum = nums[i] + nums[low] + nums[high];
                    if(sum > 0) {
                        high--;
                    }
                    else if(sum < 0) {
                        low++;
                    }
                    else {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        
                        while(low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        
                        while(low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        
                        low++;
                        high--;
                    }
                }
            }
        }
        
        return result;
    }*/
}
