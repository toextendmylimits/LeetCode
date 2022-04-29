class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Set<Integer> seen = new HashSet<>();
        int max = Integer.MIN_VALUE;
        
        for(int n : nums) {
            if(!seen.contains(n)) {
                seen.add(n);
                
                queue.offer(n);
                
                if(queue.size() > 3) {
                    queue.poll();
                }
                
                max = Math.max(max, n);
            }
        }
        
        return queue.size() < 3? max : queue.peek();
    }   
    
    /*public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int result = nums[nums.length - 1];
        
        int count = 1;
        for(int i = nums.length - 2; i >= 0; i--) {           
            if(nums[i] != nums[i + 1]) {
                count++;
            }

            if(count == 3) {
                return nums[i];
            }
        }
        
        return result;
    }*/
}
