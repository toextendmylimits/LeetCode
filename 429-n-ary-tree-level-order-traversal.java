class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) { return result; }
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                
                for(Node n : node.children) {
                    if(n != null) {
                        queue.offer(n);
                    }
                }
            }
            result.add(level);
        }
        
        return result;
    }
}
