class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int n : stones) {
            queue.offer(n);
        }
        
        while(queue.size() > 1) {
            int maxWeight = queue.poll();
            int secondMaxWeight = queue.poll();
            if(maxWeight != secondMaxWeight) {
                queue.offer(maxWeight - secondMaxWeight);
            }
        }
        
        return queue.isEmpty()? 0 : queue.peek();
    }
}
