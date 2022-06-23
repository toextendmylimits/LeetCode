class Solution {

    /*public int peakIndexInMountainArray(int[] arr) {
        int i = 0;
        while(arr[i] < arr[i+1]) {
            i++;
        }
        
        return i;
    }*/
    
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high) {
            int middle = low + (high - low) / 2;
            if(arr[middle] < arr[middle+1]) {
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }
        
        return low;
    }  
    
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 2;
        int result = -1;
        while(left <= right) {
            int middle = left + (right - left) / 2;
            if(arr[middle] > arr[middle + 1]) {
                result = middle;
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        
        return result;
    }     
}
