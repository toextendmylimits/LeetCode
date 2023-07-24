# Tree DFS
## Easy
1. [111. Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree)  
   When one child is null, then min depth should be from the other child  
   ***This can also be done in BFS***
   <details> Code
     
   ```python
     if not root:
         return 0

     if not root.left:
         return 1 + self.minDepth(root.right)
     elif not root.right:
         return 1 + self.minDepth(root.left)

     return 1 + min(self.minDepth(root.left), self.minDepth(root.right))
   ```
   
   </details>
3. [104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree)    
   ***Can also be done in BFS***
   ```python
   if not root:
      return 0

   return 1 + max(self.maxDepth(root.left), self.maxDepth(root.right))
   ```
4. [101. Symmetric Tree](https://leetcode.com/problems/symmetric-tree)    
   ***Can also be done in BFS***
   ```python
   def isMirror(self, node1, node2):
        if not node1 and not node2:
            return True
        elif not node1 or not node2:
            return False
        elif node1.val != node2.val:
            return False
        
        return self.isMirror(node1.left, node2.right) and self.isMirror(node1.right,node2.left)
   ```
1. [226. Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree)  
   ```python
   def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return None

        invertLeft = self.invertTree(root.left)
        invertRight = self.invertTree(root.right)
        root.left = invertRight
        root.right = invertLeft

        return root
   ```
1. [112. Path Sum](https://leetcode.com/problems/path-sum)  
   Base condition is return false if null, return true if targetSum equal value of a ***leaf node***
   ```python
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        if not root:
            return False
        
        if not root.left and not root.right and targetSum == root.val:
            return True

        nextTargetSum = targetSum - root.val
        return self.hasPathSum(root.left, nextTargetSum) or self.hasPathSum(root.right, nextTargetSum) 
   ```
## Medium
1. [114. Flatten Binary Tree to Linked List](https://leetcode.com/problems/flatten-binary-tree-to-linked-list)  
   dfs in preorder, return node if it's null or leaf, otherwise return rightTrail if it is not null, else return leftTrail
   ```python
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
    ```python
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
1. [543. Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree)  
   the longest path could be the sum of a node's left longest path and right longest path, so need to traverse all node, and compare the sum with global variable diameter
   ```python
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        diameter = 0
        def getDepth(node):
            if not node:
                return 0

            nonlocal diameter
            leftDepth = getDepth(node.left)
            rightDepth = getDepth(node.right)
            diameter = max(diameter, leftDepth + rightDepth)
            return max(leftDepth, rightDepth) + 1

        getDepth(root)
        return diameter
   ```
1. [1522. Diameter of N-Ary Tree](https://leetcode.com/problems/diameter-of-n-ary-tree)  
   Need to keep two largest depth of children
   ```python
   for child in node.children:
       childDepth = getDepth(child)
       if childDepth > maxDepth:
           secondMaxDepth = maxDepth
           maxDepth = childDepth
       elif childDepth > secondMaxDepth:
           secondMaxDepth = childDepth
   ```
1. [236. Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree)  
   A key restraint is p and q must exist
   ```python
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root or p == root or q == root:
            return root
        
        leftResult = self.lowestCommonAncestor(root.left, p, q)
        rightResult = self.lowestCommonAncestor(root.right, p, q)
        if leftResult and rightResult:
            return root
        return leftResult if leftResult else rightResult
   ```
1. [1644. Lowest Common Ancestor of a Binary Tree II](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii)  
   P and q are not guaranteed to exist, so always need to explore both left and right tree, and mark whether p or q has been found
   <Details>

   ```python
            left = getLCA(node.left, p, q)
            right = getLCA(node.right, p, q)
            if left and right:
                return node
            
            if p == node:
                foundP = True
                return node
            
            if q == node:
                foundQ = True
                return node
            
            return left if left else right   
   ```

   </Details>
1. [235. Lowest Common Ancestor of a Binary Search Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree)  
   If both are greater than root, then search right subtree, or both are smaller than root then search left subtree, otherwise return root
   ```python
   if p.val > node.val and q.val > node.val:
       return getLCA(node.right, p, q)
   elif p.val < node.val and q.val < node.val:
       return getLCA(node.left, p, q)
   else:
       return node   
   ```
1. [1676. Lowest Common Ancestor of a Binary Tree IV](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iv)  
   Similar to 236, except there are multiple nodes, convert it to a set for easy check
   ```python
   if not root or root in nodes:
       return root
   ```
