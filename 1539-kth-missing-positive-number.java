class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int middle = left + (right - left) / 2;
            int missingCount = arr[middle] - middle - 1;
            if(missingCount < k) {
                left = middle + 1;
            }
            else {
                right = middle - 1;
            }
        }
        
        return left + k;
    }
    
    /*public int findKthPositive(int[] arr, int k) {
        if(k < arr[0]) { return k; }
        
        k -= arr[0] - 1;
        
        for(int i = 0; i < arr.length - 1; i++) {
            int currentMissing = arr[i + 1] - arr[i] - 1;
            if(currentMissing >= k) {
                return arr[i] + k;
            }
            
            k -= currentMissing;
        }
        
        return arr[arr.length - 1] + k;
    }*/    
    
    /*public int findKthPositive(int[] arr, int k) {
        int count = 0;
        int i = 1;
        while(count < k) {
            boolean missing = true;
            for(int j = 0; j < arr.length; j++) {
                if(arr[j] == i) {
                    missing = false;
                    break;
                }
            }
            
            if(missing) {
                count++;
                if(count == k) {
                    return i;
                }
            }
            
            i++;
        }
        
        return -1;
    }*/
}
