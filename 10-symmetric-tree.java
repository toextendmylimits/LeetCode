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
    /*public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }*/
    
    public boolean isMirror(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        
        if(left == null || right == null) {
            return false;
        }
        
        if(left.val != right.val) {
            return false;
        }
        
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        
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
}
