class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Create a max heap, i.e. the top is the furthest point
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> getSquareOfDistance(b) - getSquareOfDistance(a));
        
        // Add point to heap, and remove top element if size > k
        for(int[] p : points) {
            queue.offer(p);
            if(queue.size() > k) {
                queue.poll();
            }
        }

        // Remove k elements from heap, and add to result array
        int[][] result = new int[k][];
        for(int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll();
        }
         
        return result;
    }
    
    private int getSquareOfDistance(int[] point) {
        int x = point[0];
        int y = point[1];
        return x * x + y * y;
    }
}
