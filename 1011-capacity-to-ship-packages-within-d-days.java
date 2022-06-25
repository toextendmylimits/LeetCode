class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minCapacity = 0;
        int maxCapacity = 0;
        for(int weight : weights) {
            minCapacity = Math.max(minCapacity, weight);
            maxCapacity += weight;
        }
        
        int result = maxCapacity;
        while(minCapacity <= maxCapacity) {
            int midCapacity = minCapacity + (maxCapacity - minCapacity) / 2;
            if(isCapacityEnough(midCapacity, weights, days)) {
                result = midCapacity;
                maxCapacity = midCapacity - 1;
            }
            else {
                minCapacity = midCapacity + 1;
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
