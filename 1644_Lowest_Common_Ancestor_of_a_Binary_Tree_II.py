I do a bottom-up traversal like the normal LCA problem, returning a node when I find either target.
At the same time, I track whether each target node is actually found in the tree.
If both are found, I return the split point as the LCA; otherwise, I return null.

class Solution:
    def lowestCommonAncestor(self, root, p, q):
        found_p = False
        found_q = False

        def dfs(node):
            nonlocal found_p, found_q
            if not node:
                return None
            
            left = dfs(node.left)
            right = dfs(node.right)

            if node == p:
                found_p = True
                return node
            
            if node == q:
                found_q = True
                return node

            if left and right:
                return node
            
            return left or right

        lca = dfs(root)
        return lca if found_p and found_q else None
