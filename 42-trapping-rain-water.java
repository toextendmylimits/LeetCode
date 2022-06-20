class Solution {
    public int trap(int[] height) {
        int result = 0;
        int left = 0;;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        
        while(left < right) {
            if(height[left] < height[right]) {
                if(height[left] >= maxLeft) {
                    maxLeft = height[left];
                }
                else {
                    result += maxLeft - height[left];
                }
                
                left++;
            }
            else {
                if(height[right] >= maxRight) {
                    maxRight = height[right];
                }
                else {
                    result += maxRight - height[right];
                }
                
                right--;
            }
        }
        
        return result;
    }    
    
    // Dynamic programming
    /*public int trap(int[] height) {
        int result = 0;
        int[] leftMost = new int[height.length];
        int[] rightMost = new int[height.length];
        
        leftMost[0] = height[0];
        for(int i = 1; i < height.length; i++) {
            leftMost[i]= Math.max(height[i], leftMost[i - 1]);
        }
        
        rightMost[height.length - 1] = height[height.length - 1];
        for(int j = height.length - 2; j >= 0; j--) {
            rightMost[j] = Math.max(height[j], rightMost[j + 1]);
        }

        for(int k = 1; k < height.length - 1; k++) {
            result += Math.min(leftMost[k], rightMost[k]) - height[k];
        }
        
        return result;
    }*/   
    /*public int trap(int[] height) {
        int result = 0;
        for(int i = 0; i < height.length; i++) {
            int leftMax = height[i];
            for(int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            
            int rightMax = height[i];
            for(int k = i + 1; k < height.length; k++) {
                rightMax = Math.max(rightMax, height[k]);
            }
            
            result += Math.min(leftMax, rightMax) - height[i];
        }
        
        return result;
    }*/
    public int trap(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        while(left < right) {
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);
            if(maxLeft < maxRight) {
                result += maxLeft - height[left];
                left++;
            }
            else {
                result += maxRight - height[right];
                right--;
            }
        }
        
        return result;
    }    
}
