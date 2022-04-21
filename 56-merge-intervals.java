class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) {
            return intervals;
        }
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        
        for(int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int[] previousMergedInterval = result.get(result.size() - 1);
            if(interval[0] <= previousMergedInterval[1]) {
                previousMergedInterval[1] = Math.max(previousMergedInterval[1], interval[1]);
            }
            else {
                result.add(interval);
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}
