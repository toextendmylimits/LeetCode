class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);        
        List<int[]> result = new ArrayList<>(); 
        for(int[] interval : intervals) {
            int lastIndex = result.size() - 1;
            if(result.isEmpty() || interval[0] > result.get(lastIndex)[1]) {
                result.add(interval);
            }
            else {
                result.get(lastIndex)[1] = Math.max(result.get(lastIndex)[1], interval[1]);
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}
