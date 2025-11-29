# Approach 1: Recursive DFS

Because this is a BST, both p and q will be in the left subtree if their values are less than the current node, and in the right subtree if both are greater.
I recurse left or right accordingly.
When the values split — meaning one is on each side or one equals the root — I’ve found the LCA.
This is O(h) time and O(h) recursion space.

class Solution:
  def lowestCommonAncestor(self, root, p, q):
      if root.val > p.val and root.val > q.val:
          return self.lowestCommonAncestor(root.left, p, q)
      if root.val < p.val and root.val < q.val:
          return self.lowestCommonAncestor(root.right, p, q)
      return root

# Approach 2: Iterative

In a BST, p and q must lie either both in the left subtree, both in the right, or split across the current root.
I walk down from the root: if both p and q are smaller, go left; if both are larger, go right; otherwise this node is the split point and hence the LCA.
This runs in O(h) time with O(1) space.
  
class Solution:
    def lowestCommonAncestor(self, root, p, q):
        curr = root
        
        while curr:
            if p.val < curr.val and q.val < curr.val:
                curr = curr.left    # both in left subtree
            elif p.val > curr.val and q.val > curr.val:
                curr = curr.right   # both in right subtree
            else:
                return curr         # split point → LCA
