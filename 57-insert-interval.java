class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int i = 0;
        int len = intervals.length;
        while(i < len && intervals[i][1] < newStart) {
            result.add(intervals[i]);
            i++;
        }
        
        while(i < len && intervals[i][0] <= newEnd) {
            newStart = Math.min(intervals[i][0], newStart);
            newEnd = Math.max(intervals[i][1], newEnd);
            i++;
        }
        result.add(new int[] { newStart, newEnd });
        
        while(i < len) {
            result.add(intervals[i]);
            i++;
        }
        
        return result.toArray(new int[result.size()][]);
    }
}
