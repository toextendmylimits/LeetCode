class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totalWeight = Arrays.stream(stones).sum();
        int targetWeight = totalWeight / 2;
        int[] dp = new int[targetWeight + 1];
        for(int i = 0; i < stones.length; i++) {
            int stoneWeight = stones[i];
            for(int weight = targetWeight; weight >= stoneWeight; weight--) {
                dp[weight] = Math.max(dp[weight], dp[weight - stoneWeight] + stoneWeight);
            }
        }
        
        return totalWeight - 2 * dp[targetWeight];
    }
}
