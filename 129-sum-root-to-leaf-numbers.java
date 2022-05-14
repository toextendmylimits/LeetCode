class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null) { return 0; }
        
        int result = 0;
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        stack.push(new Pair<TreeNode, Integer>(root, 0));
        
        while(!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            int currNum = pair.getValue();
            currNum = currNum * 10 + node.val;
            if(node.left == null && node.right == null) {
                result += currNum;
            }
            
            if(node.right != null) {
                stack.push(new Pair<TreeNode, Integer>(node.right, currNum));
            }
            
             if(node.left != null) {
                stack.push(new Pair<TreeNode, Integer>(node.left, currNum));
            }
        }
        
        return result;
    }
    
    int totalSum = 0;
    /*public int sumNumbers(TreeNode root) {
        preorder(root, 0);
        
        return totalSum;
    }*/

    private void preorder(TreeNode root, int currNumber) {
        if(root == null) { 
            return;
        }
        
        currNumber = currNumber * 10 + root.val;
        
        if(root.left == null && root.right == null) {
            totalSum += currNumber;
        }
        
        preorder(root.left, currNumber);
        preorder(root.right, currNumber);
        
    }
}
