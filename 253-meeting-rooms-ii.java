class Solution {
    /*public int minMeetingRooms(int[][] intervals) {
        // Sort meeting ascendingly by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);    
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for(int[] interval : intervals) {
            heap.offer(interval);
            if(heap.peek()[1] <= interval[0]) { // Remove a meeting as it finishes
                heap.poll();
            }
        }
        
        return heap.size();
    }*/
    public int minMeetingRooms(int[][] intervals) {
        // Sort meeting ascendingly by start time
        int len = intervals.length;
        int[] startTimes = new int[len] ;
        int[] endTimes = new int[len];
        for(int i = 0; i < len; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }
        
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        
        int rooms = 0;
        int earlisetEndTimeIndex = 0;
        for(int i = 0; i < len; i++) {
            if(startTimes[i] < endTimes[earlisetEndTimeIndex]) {
                rooms++;
            }
            else {
                earlisetEndTimeIndex++;
            }
        }
        
        return rooms;
    }    
}
