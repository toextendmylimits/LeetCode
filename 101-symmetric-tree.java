class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) { return false; } 
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()) {
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();
            if(first == null && second == null) {
                continue;
            }
            else if(first == null || second == null) {
                return false;
            }
            else if(first.val != second.val) {
                return false;
            }
            queue.offer(first.left);
            queue.offer(second.right);
            queue.offer(first.right);
            queue.offer(second.left);
        }
        
        return true;
    }
    
    /*public boolean isSymmetric(TreeNode root) {
        if(root == null) { return false; } 
        return isSymmetric(root.left, root.right);
    }*/
    
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        
        if(left == null || right == null) {
            return false;
        }
        
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
