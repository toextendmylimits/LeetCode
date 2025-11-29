# 
A BST is valid only if every node fits into a valid value range.
I use DFS and pass down a (lower, upper) bound. For each node, 
its value must be strictly between those bounds. 
For the left child, the upper bound becomes the current node’s value; 
for the right child, the lower bound becomes the current value. 
If any node violates the bounds, I return false. If all nodes satisfy their ranges, it’s a valid BST.



class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def validate(node, lower, upper):
            if not node:
                return True
            
            # Check BST property: value must be in (lower, upper)
            if not (lower < node.val < upper):
                return False
            
            # Left: upper bound becomes node.val
            # Right: lower bound becomes node.val
            return validate(node.left, lower, node.val) and \
                   validate(node.right, node.val, upper)
        
        return validate(root, float("-inf"), float("inf"))
