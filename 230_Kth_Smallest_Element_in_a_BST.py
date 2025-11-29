
I perform an inorder traversal, which visits BST nodes in sorted order.
Each time I visit a node, I decrement k.
Once k reaches zero, that node is the k-th smallest.
I use recursion to traverse left → node → right and short-circuit once the answer is found.

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        result = None

        def inorder(node):
            nonlocal k, result
            if not node or result is not None:
                return

            inorder(node.left)

            k -= 1
            if k == 0:
                result = node.val
                return

            inorder(node.right)

        inorder(root)
        return result
