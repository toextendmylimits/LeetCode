# Recursive inorder DFS
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

# Iterative
I simulate inorder traversal using a stack.
The loop continues as long as there's a node to explore or nodes in the stack.
I push all left nodes, pop one (that’s the next smallest), decrement k, and if k hits zero I return it.
Then I move to the right subtree.
This correctly visits BST nodes in sorted order without recursion.
    
class Solution:
    def kthSmallest(self, root, k):
        stack = []
        curr = root

        while stack or curr:
            while curr:
                stack.append(curr)
                curr = curr.left

            curr = stack.pop()
            k -= 1
            if k == 0:
                return curr.val

            curr = curr.right
