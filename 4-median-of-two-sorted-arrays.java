class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int x= nums1.length;
        int y = nums2.length;
        
        int low = 0;
        int high = x;
        while(low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;
            
            int maxLeftX = partitionX == 0? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = partitionX == x? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxLeftY = partitionY == 0? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = partitionY == y? Integer.MAX_VALUE : nums2[partitionY];
            
            if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if((x + y) % 2 == 0) {
                    return 1.0 * (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                }
                else {
                    return 1.0 * Math.max(maxLeftX, maxLeftY);
                }
            }
            else if(maxLeftX > minRightY) {
                high = partitionX - 1;
            }
            else if(maxLeftY > minRightX) {
                low = partitionX + 1;
            }          
        }
        
        throw new IllegalArgumentException("No valid result! Arrays must not be sorted");
    }
    // Time complexity O(m + n), space complexity O(m + n)
    /*public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int mergedLen = len1 + len2;
        int[] merged = new int[mergedLen];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < len1 || j < len2) {
            if(i < len1 && j < len2) {
                if(nums1[i] > nums2[j]) {
                    merged[k] = nums2[j];
                    j++;
                }
                else{
                    merged[k] = nums1[i];
                    i++;
                }
            }
            else if(i < len1) {
                merged[k] = nums1[i];
                i++;
            }
            else if(j < len2) {
                merged[k] = nums2[j];
                j++;
            }
            k++;
        }
        
        int half = mergedLen / 2;
        return mergedLen % 2 == 0? 1.0 * (merged[half] + merged[half - 1]) / 2:
        1.0 * merged[half];
    }*/
}
