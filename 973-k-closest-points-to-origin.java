class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> {
            return (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]);
        });
        
        for(int[] p : points) {
            queue.offer(p);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        
        int[][] result = new int[k][2];        
        int index = 0;
        while(index < k) {
            result[index] = queue.poll();
            index++;
        }
        
        return result;
    }

    /*public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, Comparator.comparing(p -> p[0] * p[0] + p[1] * p[1]));
        
        return Arrays.copyOfRange(points, 0, k);
    }*/
}
