class Solution {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> merged = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for(int[] interval : intervals) {
            if(merged.isEmpty() || interval[0] > merged.getLast()[1]) {
                merged.add(interval);
            }
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
    }
}
