class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int meetings = intervals.length;
        int[] starts = new int[meetings];
        int[] ends = new int[meetings];
        for(int i = 0; i < meetings; i++) {
            int[] interval = intervals[i];
            starts[i] = interval[0];
            ends[i] = interval[1];
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int rooms = 0;
        int endIndex = 0;
        for(int i = 0; i < meetings; i++) {
            if(starts[i] < ends[endIndex]) {
                rooms++;
            }
            else {
                endIndex++;
            }
        }
        
        return rooms;
    }
}
