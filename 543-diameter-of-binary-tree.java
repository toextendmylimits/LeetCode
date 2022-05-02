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
    private int diameter;
    private List<TreeNode> nodes;
public int diameterOfBinaryTree(TreeNode root) {
        if( root == null){
            return 0;
        }

        int diameter = 0;
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode,Integer> map = new HashMap<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(node.left != null && !map.containsKey(node.left)){
                stack.push(node.left);
            } else if(node.right != null && !map.containsKey(node.right)){
                stack.push(node.right);
            } else {
                stack.pop();
                int leftDepth = map.getOrDefault(node.left, 0);
                int rightDepth = map.getOrDefault(node.right, 0);
                map.put(node, 1 + Math.max(leftDepth, rightDepth));
                diameter = Math.max(diameter, leftDepth + rightDepth );
            }
            
        }
        return diameter;
        
    }     
    /*public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        nodes = new ArrayList<>();
        getNodesOfMaxDepth(root);
        
        //getMaxDepth(root);
        
        return nodes.size() - 1 > 0 ? nodes.size() -1 : 0;
    }*/
    
    private int getMaxDepth(TreeNode root) {
        if(root == null) { return 0; }
        
        int leftDepth = getMaxDepth(root.left);
        int rightDepth = getMaxDepth(root.right);
        
        diameter = Math.max(diameter, leftDepth + rightDepth);
        
        return Math.max(leftDepth, rightDepth) + 1;
    }

    private List<TreeNode> getNodesOfMaxDepth(TreeNode root) {
        if(root == null) { return new ArrayList<>(); }
        
        List<TreeNode> leftNodes = getNodesOfMaxDepth(root.left);
         List<TreeNode> rightNodes = getNodesOfMaxDepth(root.right);
        
        int sumOfLeftRightDepth = leftNodes.size() + rightNodes.size();
        if(sumOfLeftRightDepth > diameter) {
            diameter = sumOfLeftRightDepth;
            nodes = new ArrayList<>();
            nodes.addAll(leftNodes);
            nodes.add(root);
            nodes.addAll(rightNodes);
        }
        
        List<TreeNode> path = new ArrayList<TreeNode>(leftNodes.size() > rightNodes.size()? leftNodes : rightNodes);
        path.add(root);
        return path;
    }
}
