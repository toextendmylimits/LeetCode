class Solution {
    TreeNode xParent = null;
    TreeNode yParent = null;
    int xDepth = 0;
    int yDepth = 0;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) { return false; }
        
        setDepthAndParent(root, x, y, null, 0);
        
        return xDepth == yDepth && xParent != yParent;    
    }
    
    private void setDepthAndParent(TreeNode child, int x, int y, TreeNode parent, int depth) {
        if(child == null) { return; }
        
        if(child.val == x) {
            this.xDepth = depth;
            xParent = parent;
        }
        else if(child.val == y) {
            this.yDepth = depth;
            yParent = parent;
        }
        else {
            setDepthAndParent(child.left, x, y, child, depth + 1);
            setDepthAndParent(child.right, x, y, child, depth + 1);
        }
    }
    
    /*public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) { return false; }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean hasX = false;
            boolean hasY = false;
    
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.val == x) {
                    hasX = true;
                }
                else if(node.val == y) {
                    hasY = true;
                }
                
                if(node.left != null && node.right != null) {
                    if((node.left.val == x && node.right.val == y) ||(node.left.val == y && node.right.val == x)) {
                        return false;
                    }
                }                      
                                       
                if(hasX && hasY) {
                    return true;
                }
                       
                if(node.left != null) { queue.offer(node.left); }
                if(node.right != null) { queue.offer(node.right); }
            }
        }
        
        return false;
    }*/
}
