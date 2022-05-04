class Solution {
    /*public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        
        return -1;
    }*/
    
    // Use set
    /*public int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for(int n : nums) {
            if(!seen.add(n)) {
                return n;
            }
        }
        
        return -1;
    }*/
    
    // Negative marking
    /*public int findDuplicate(int[] nums) {
        int duplicate = -1;
        for(int i = 0; i < nums.length; i++) {
            int cur = Math.abs(nums[i]);
            if(nums[cur] < 0) {
                duplicate = cur;
                break;
            }
            
            nums[cur] *= -1;
        }
        
        for(int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        
        return duplicate;
    }*/
    public int findDuplicate(int[] nums) {
        int duplicate = -1;
        int left = 1;
        int right = nums.length - 1;
        while(left <= right) {
            int middle = left + (right - left) / 2;
            
            int count = 0;
            for(int n : nums) {
                if(n <= middle) {
                    count++;
                }
            }
            
            if(count > middle) {
                duplicate = middle;
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        
        return duplicate;
    }    
}
