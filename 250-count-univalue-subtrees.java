class Solution {
    int count = 0;

    boolean isUnivalSubTree(TreeNode root) {
        if(root == null) { return true; }
        
        boolean left = isUnivalSubTree(root.left);
        boolean right = isUnivalSubTree(root.right);
        if(left && right) {
            if(root.left != null && root.left.val != root.val) {
                return false;
            } 
            if(root.right != null && root.right.val != root.val) {
                return false;
            }
            count++;
            return true;
        }
        
        return false;
    }
    public int countUnivalSubtrees(TreeNode root) {
        isUnivalSubTree(root);
        return count;
    }
   
    /*public int countUnivalSubtrees(TreeNode root) {
        setCount(root);
        
        return count;
    }*/
    
    private void setCount(TreeNode root) {
        if(root == null) { return; }
        
        if(isUnivalTree(root, null)) {
            count++;
        }
        
        setCount(root.left);
        setCount(root.right);
    }
    
    private boolean isUnivalTree(TreeNode root, Integer val) {
        if(root == null) {
            return true;
        }
        
        if(val != null && root.val != val) {
            return false;
        }
        
        return isUnivalTree(root.left, root.val) && isUnivalTree(root.right, root.val);
    }
}
