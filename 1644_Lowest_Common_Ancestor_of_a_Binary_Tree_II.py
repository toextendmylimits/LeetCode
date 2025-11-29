I modified the normal LCA recursion so that I also track whether p and q actually exist in the tree.
During DFS, whenever I hit p or q, I set a flag and return that node upward.
If both left and right recursions return non-null, the current node is their LCA.
After the DFS completes, if both flags are true, I return the found LCA; otherwise I return null.
This ensures we correctly handle the case where one or both nodes don’t exist.

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
