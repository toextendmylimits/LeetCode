# Tree DFS
## Easy
1. [111. Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree)  
   When one child is null, then min depth should be from the other child  
   ***This can also be done in BFS***
   ```python
     if not root:
         return 0

     if not root.left:
         return 1 + self.minDepth(root.right)
     elif not root.right:
         return 1 + self.minDepth(root.left)

     return 1 + min(self.minDepth(root.left), self.minDepth(root.right))
   ```
2. [104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree)    
   ***Can also be done in BFS***
   ```
   if not root:
      return 0

   return 1 + max(self.maxDepth(root.left), self.maxDepth(root.right))
   ```
3. [101. Symmetric Tree](https://leetcode.com/problems/symmetric-tree)    
   ***Can also be done in BFS***
   ```
   def isMirror(self, node1, node2):
        if not node1 and not node2:
            return True
        elif not node1 or not node2:
            return False
        elif node1.val != node2.val:
            return False
        
        return self.isMirror(node1.left, node2.right) and self.isMirror(node1.right,node2.left)
   ```
## Medium
1. [114. Flatten Binary Tree to Linked List](https://leetcode.com/problems/flatten-binary-tree-to-linked-list)  
   dfs in preorder, return node if it's null or leaf, otherwise return rightTrail if it is not null, else return leftTrail
   ```
   def dfs(node):
      if not node or (not node.left and not node.right):
          return node

      leftTrail = dfs(node.left)
      rightTrail = dfs(node.right)

      if leftTrail:
          leftTrail.right = node.right
          node.right = node.left 
          node.left = None
      return rightTrail if rightTrail else leftTrail
   ``` 
 2. [110. Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree)   
    Use -1 as a unbalanced tree's height, if either left or not is not balanced, or depth difference is greater than 1, tree is not balanced
    ```
    def getHeight(self, node):
        if not node:
            return 0

        leftHeight = self.getHeight(node.left)
        if leftHeight == -1:
            return -1

        rightHeight = self.getHeight(node.right)
        if rightHeight == -1:
            return -1

        if abs(leftHeight - rightHeight) > 1:
            return -1

        return 1 + max(leftHeight, rightHeight) 
    ```
