    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<TreeNode> set = new HashSet<TreeNode>();
        for(TreeNode n : nodes) {
            set.add(n);
        }
        
        return findLowestCommonAncestor(root, set);
    }
    
    private TreeNode findLowestCommonAncestor(TreeNode root, Set<TreeNode> nodes) {
        if(root == null) { return null; }
        
        if(nodes.contains(root)) {
            return root;
        }
        
        TreeNode left = findLowestCommonAncestor(root.left, nodes);
        TreeNode right = findLowestCommonAncestor(root.right, nodes);
        if(left != null && right != null) {
            return root;
        }
        
        return left == null? right : left;
    }
