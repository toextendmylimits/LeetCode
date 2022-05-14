class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {       
        int pVal = p.val;
        int qVal = q.val;
        while(root != null) {
            int parentVal = root.val;
            if(pVal > parentVal && qVal > parentVal) {
                root = root.right;
            }
            else if(pVal < parentVal && qVal < parentVal) {
                root = root.left;    
            }
            else {
                return root;
            }
        }
        
        return null;
    }
    
    /*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) { return null; }
        
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;
        if(pVal > parentVal && qVal > parentVal) {
            return lowestCommonAncestor(root.right, p, q);
        }
        else if(pVal < parentVal && qVal < parentVal) {
            return lowestCommonAncestor(root.left, p, q);
        }
        else {
            return root;
        }
    }*/   
}
