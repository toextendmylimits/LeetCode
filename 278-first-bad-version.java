/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int result = 0;
        int left = 1;
        int right = n;
        while(left <= right) {
            int pivot = left + (right - left) / 2;
            
            if(isBadVersion(pivot)) {
                result = pivot;
                
                // Check whether there is previous bad version, i.e. bad version on left
                right = pivot - 1;
            }
            else {
                left = pivot + 1;
            }
        }
        
        return result;
    }
}
