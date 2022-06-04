class Solution {
    /*public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] result = new int[len];
        k = k % len;
        for(int i = 0; i < len; i++) {
            result[i] = nums[(i - k + len) % len];
        }
        
        for (int i = 0; i < nums.length; i++) {
          nums[i] = result[i];
        }
    }*/
    
    /*public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] result = new int[len];
      
        for(int i = 0; i < len; i++) {
            result[(i + k) % len] = nums[i];
        }
        
        for (int i = 0; i < nums.length; i++) {
          nums[i] = result[i];
        }
    }*/ 
    
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        
        k %= len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }  
    
    public void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
        /*for(int i = start, j = end; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }*/
    }
}
