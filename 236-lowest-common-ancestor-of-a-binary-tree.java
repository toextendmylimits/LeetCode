class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {       
        if(root == null ) { return null; }
        
        Map<TreeNode, TreeNode> childParentMap = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            if(childParentMap.containsKey(p) && childParentMap.containsKey(q)) {
                break;
            }
            TreeNode node = stack.pop();
            if(node.right != null) {
                stack.push(node.right);
                childParentMap.put(node.right, node);
            }
            
            if(node.left != null) {
                stack.push(node.left);
                childParentMap.put(node.left, node);
            }
        }
        
        Set<TreeNode> ancestorsOfP = new HashSet<>();
        while(p != null) {
            ancestorsOfP.add(p);
            p = childParentMap.get(p);
        }
        
        while(!ancestorsOfP.contains(q)) {
            q = childParentMap.get(q);
        }
        
        return q;
    }
    
    /*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {       
        if(root == null ) { return null; }
        
        if(root == p || root == q) { return root; }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) {
            return root;
        }
        
        return left == null? right : left;
    }*/    
}
