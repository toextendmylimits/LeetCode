class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) { return false; }
        
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, targetSum));

        while(!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            int sum = pair.getValue();
            if(node.left == null && node.right == null && sum == node.val) {
                return true;
            }
            if(node.right != null) {
                stack.push(new Pair<>(node.right, sum - node.val));
            }
            
            if(node.left != null) {
                stack.push(new Pair<>(node.left, sum - node.val));
            }
        }
        
        return false;
    }    
    /*public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) { return false; }
        
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);
        Stack<Integer> sumStack = new Stack<>();
        sumStack.push(targetSum);
        while(!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int sum = sumStack.pop();
            if(node.left == null && node.right == null && sum == node.val) {
                return true;
            }
            if(node.right != null) {
                nodeStack.push(node.right);
                sumStack.push(sum - node.val);
            }
            
            if(node.left != null) {
                nodeStack.push(node.left);
                sumStack.push(sum - node.val);
            }
        }
        
        return false;
    }*/
    
    /*public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) { return false; }
        
        if(root.left == null && root.right == null && targetSum == root.val) { return true; }
        
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }*/
}
