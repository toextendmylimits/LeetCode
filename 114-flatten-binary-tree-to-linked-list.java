class Solution {
    public void flatten(TreeNode root) {
         flattenTree(root);             
    }
    
    private TreeNode flattenTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return root;
        }
        
        TreeNode leftTail = flattenTree(root.left);
        TreeNode rightTail = flattenTree(root.right);
        
        if(leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        return rightTail == null? leftTail : rightTail;
    }
}
