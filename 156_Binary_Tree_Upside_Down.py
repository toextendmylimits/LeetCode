I recursively go to the leftmost node, because that will become the new root.  
Then when the recursion unwinds, I rewire the pointers:  
The original left child’s left pointer becomes the original right child, and its right pointer becomes the original root.  
Finally, I clear root.left and root.right so the structure doesn’t form cycles.  

class Solution:
    def upsideDownBinaryTree(self, root):
        if not root or not root.left:
            return root
        
        newRoot = self.upsideDownBinaryTree(root.left)
        
        # root.left becomes root's parent
        root.left.left = root.right
        root.left.right = root
        
        # detach
        root.left = None
        root.right = None
        
        return newRoot
