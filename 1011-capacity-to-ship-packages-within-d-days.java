class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for(int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        
        int result = right;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(isCapacityEnough(mid, weights, days)) {
                result = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        
        return result;
    }
    
    private boolean isCapacityEnough(int capacity, int[] weights, int days) {
        int daysNeeded = 1;
        int totalWeight = 0;
        for(int weight : weights) {
            totalWeight += weight;
            if(totalWeight > capacity) {
                daysNeeded++;
                totalWeight = weight;
                if(daysNeeded > days) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
