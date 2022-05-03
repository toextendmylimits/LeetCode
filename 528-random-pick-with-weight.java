class Solution {
    private int totalSum;
    private int[] prefixSums;
    public Solution(int[] w) {
        totalSum = 0;
        prefixSums = new int[w.length];
        
        int currentSum = 0;
        for(int i = 0; i < w.length; i++) {
            currentSum += w[i];
            prefixSums[i] += currentSum;
        }
        
        totalSum = prefixSums[w.length - 1];
    }
    
    public int pickIndex() {
        double target = Math.random() * totalSum;
        
        /*for(int i = 0; i < prefixSum.length; i++) {
            if(target < prefixSum[i]) {
                return i;
            }
        }*/
        int left = 0;
        int right = prefixSums.length;
        while(left < right) {
            int middle = left + (right - left) / 2;
            if(target > prefixSums[middle]) {
                left = middle + 1;
            }
            else {
                right = middle;
            }
        }
        
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
