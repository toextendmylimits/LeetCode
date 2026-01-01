# 
I traverse the tree bottom-up. If a node is one of the targets, I return it.  
I check both subtrees.  
If both sides find a target, the current node is the lowest common ancestor.  
Otherwise, I propagate the found node upward.  

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # Base case: hit null or find p or q
        if not root or root == p or root == q:
            return root
        
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        
        # If p and q found in both sides, this root is LCA
        if left and right:
            return root
        
        # Otherwise, return the non-null side
        return left if left else right
