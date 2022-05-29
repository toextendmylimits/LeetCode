class Solution {
    /*public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) { 
                if(nums[j] <= nums[i]) {
                    continue;
                }
                
                for(int k = j + 1; k < len; k++) {
                    if(nums[k] <= nums[j]) {
                        continue;
                    }
                    
                    return true;
                }
            }
        }
        
        return false;
    }*/
    
    public boolean increasingTriplet(int[] nums) {
        int smallestNum = Integer.MAX_VALUE;
        int secondSmallestNum = Integer.MAX_VALUE;
        
        for(int n : nums) {
            if(n <= smallestNum) {
                smallestNum = n;
            }
            else if(n <= secondSmallestNum) {
                secondSmallestNum = n;
            }
            else {
                return true;
            }
        }
        return false;
    }    
}
