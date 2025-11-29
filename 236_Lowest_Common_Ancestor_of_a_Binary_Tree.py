# 
I solve LCA using a bottom-up DFS.
If the current node is null or matches p or q, I return it immediately.
Then I recursively search left and right.
If both sides return non-null, that means p and q were found in different subtrees, so the current node is the LCA.
If only one side is non-null, I return that value upward — essentially bubbling up the found node so ancestors can use it to determine the LCA.
The time complexity is O(n) and space is O(h) due to recursion depth.

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
