/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }  
    
    private boolean validate(TreeNode root, Integer low, Integer high) {
        if(root == null) { return true; }
        if((low != null && root.val <= low) || (high != null && root.val >= high)) { return false; }
        
        return validate(root.left, low, root.val) && validate(root.right, root.val, high);
    }
    /*public boolean isValidBST(TreeNode root) {
        if(root == null) { return true; }
        
        Integer prev = null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;
        while(current != null || !stack.isEmpty()) {
            if(current != null) {
                stack.push(current);
                current = current.left;
            }
            else {
                 current = stack.pop();
                if(prev != null && current.val <= prev) {
                    return false;
                }
                prev = current.val;
                current = current.right;               
            }
        }
        
        return true;
    }*/
    
    Integer prev;
    /*public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }*/
    
    private boolean inorder(TreeNode root) {
        if(root == null) { return true; }
        
        if(!inorder(root.left)) { return false; }
        
        if(prev != null && root.val <= prev) {
            return false;
        }
        
        prev = root.val;
        return inorder(root.right);
    }
}
