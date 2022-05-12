class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root == null) { return result; }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                sum += temp.val;
                
                if(temp.left != null) { queue.offer(temp.left); }
                if(temp.right != null) { queue.offer(temp.right); }
            }
            
            result.add(sum / size);
        }
        
        return result;
    }
}
