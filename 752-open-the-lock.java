class Solution {
    public int openLock(String[] deadends, String target) {
        String initialSequence = "0000";
        Set<String> visitedOrDeadendSet = new HashSet<>(List.of(deadends));
        if(visitedOrDeadendSet.contains(initialSequence)) {
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(initialSequence);        
        visitedOrDeadendSet.add(initialSequence);
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String code = queue.poll();
                if(code.equals(target)) {
                    return level;
                }

                for(String neighbor : getNeighbours(code)) {
                    if(visitedOrDeadendSet.contains(neighbor)) {
                        continue;
                    }                    
                    queue.offer(neighbor);
                    visitedOrDeadendSet.add(neighbor); 
                }
            }
            level++;
        }
        
        return -1;
    }
   
    private List<String> getNeighbours(String code) {
        List<String> result = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            for(int diff = -1; diff <= 1; diff += 2) {
                int digit = (code.charAt(i) - '0' + diff + 10) % 10;
                result.add(code.substring(0, i) + String.valueOf(digit) + code.substring(i + 1));
            }
        }
        
        return result;
    }
}
