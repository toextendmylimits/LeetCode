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
        int[] result = new int[2]; // first element for not robbing root, second element for robbing root
        if(root == null) { return result; }
        
        int[] resultRobbingLeft = robTree(root.left);
        int[] resultRobbingRight = robTree(root.right);
        
        int moneyRobbingRoot = root.val + resultRobbingLeft[0] + resultRobbingRight[0];
        int moneyNotRobbingRoot = Math.max(resultRobbingLeft[0], resultRobbingLeft[1]) + Math.max(resultRobbingRight[0], resultRobbingRight[1]);
        result[0] = moneyNotRobbingRoot;
        result[1] = moneyRobbingRoot;
        
        return result;
    }
}
