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
    public int rob(TreeNode root) {
        int[] result = robTree(root);
        return Math.max(result[0], result[1]);
    }
    
    public int[] robTree(TreeNode root) {
        int[] result = new int[2]; // 0 for not robbing root, 1 for robbing root
        if(root == null) { return result; }
        
        int[] left = robTree(root.left);
        int[] right = robTree(root.right);
        
        int moneyRobbingRoot = root.val + left[0] + right[0];
        int moneyNotRobbingRoot = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[0] = moneyNotRobbingRoot;
        result[1] = moneyRobbingRoot;
        
        return result;
    }
}
