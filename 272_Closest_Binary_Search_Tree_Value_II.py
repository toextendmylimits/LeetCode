Inorder traverse the BST → produce a sorted list of values.
Sort the list by absolute distance from target.
Return the first k values.

class Solution:
    def closestKValues(self,root, target, k):
        vals = []
        def inorder(node):
            if not node:
                return
            inorder(node.left)
            vals.append(node.val)
            inorder(node.right)
        inorder(root)
        vals.sort(key=lambda x : abs(x - target))
        return vals[:k]
