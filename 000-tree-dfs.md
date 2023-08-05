# Tree DFS
## Easy
1. [Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal)  
   Should be able to traverse the tree iteratively as well  
2. [108. Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree)  
   Choose the mid value to be root, and use left half to construct left subtree, and right half to construct right subtree  
   The base condition is ***if left is greater than right, return None*** because there there is no subtree can be built  
   ***Time complexity*** is O(N) as all nodes are visited once  
   ***Space complexity*** is O(logN) for recursion call stack as the tree is balanced  
1. [111. Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree)  
   When one child is null, then min depth should be from the other child  
   ***This can also be done in BFS***
   <details> 
     
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
1. [104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree)    
   ***Can also be done in BFS***
   ```python
   if not root:
      return 0

   return 1 + max(self.maxDepth(root.left), self.maxDepth(root.right))
   ```
1. [101. Symmetric Tree](https://leetcode.com/problems/symmetric-tree)    
   ***Can also be done in BFS***
   <details>
      
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
   </details>
1. [226. Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree)  
   <details>
      
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
   </details>
1. [112. Path Sum](https://leetcode.com/problems/path-sum)  
   The most intutive approach is to   
   use recursion. At each step, decrease the sum by the node's value. If the node is a leaf, and sum is zero, then return True; If node is not a leaf, exploring its childen recursively
   ***Also if not is None, return False***
   <details>
      
      ```python
       def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
       def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
           if not root:
               return False
   
           targetSum -= root.val
           if not root.left and not root.right:
               return targetSum == 0
   
           return self.hasPathSum(root.left, targetSum) or self.hasPathSum(root.right, targetSum)
      ```
   </details>
1. [98. Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree)  
   Recursively traverse the tree, and for each node, check whether its value is in a valid range   
   When checking whether limit is null, remember to use if upper is not None instead if upper as otherwise 0 would be treat invalid
   <details>
      
      ```python
            if not root:
                return True

            if lower is not None and root.val <= lower:
                return False
            if upper is not None and root.val >= upper:
                return False
            
            return isValid(root.left, lower, root.val) and isValid(root.right, root.val, upper)
      ```
   </details>
1. [1430. Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree](https://leetcode.com/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree) 
   1. If reached the end of the current subtree or the input arr, or current node value does NOT match the value of arr, then current sequence is NOT valid
   1. if current node is a leave, check if the end of arr reached, if yes it is a valid sequence, return true, otherwise false;
   1. Other cases, increase the depth by 1 and recurse to the children; if both end up with false, the result is false, otherwise true. 
   <details>

   ```python
    def isValidSequence(self, root: Optional[TreeNode], arr: List[int]) -> bool:
        def isValid(node, arr, depth):
            if not node or depth >= len(arr) or node.val != arr[depth]:
                return False

            if not node.left and not node.right:
                return depth == len(arr) - 1
            
            depth += 1
            return isValid(node.left, arr, depth) or isValid(node.right, arr, depth)
        return isValid(root, arr, 0)
   ```
   </details>
1. [222. Count Complete Tree Nodes](https://leetcode.com/problems/count-complete-tree-nodes)
   ***Very difficult to solve the problem in O(logN)***
   <details>

   ```python
        if root is None:
            return 0

        return 1 + self.countNodes(root.left) + self.countNodes(root.right)
   ```
   </details>
## Medium
1. [114. Flatten Binary Tree to Linked List](https://leetcode.com/problems/flatten-binary-tree-to-linked-list)  
   dfs in postorder 
   1. return node if it's null or leaf   
   1. then if letTrail is not null, connect leftTrail with right subtree, and connect node with left subtree,
   1. In the end return rightTrail if it is not null, else return leftTrail
   <details>

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
   </details>
 2. [110. Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree)   
    Use -1 as a unbalanced tree's height, if either left or not is not balanced, or depth difference is greater than 1, tree is not balanced
    <details>

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
   </details>
   
1. [543. Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree)   
   1. If the path go through a node, then it equals the sum of left subtree's height and right subtree's height
   1. So we traverse the tree, for each node, find its height, update diameter if needed
   <details>
       
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
   </details>
    
1. [1522. Diameter of N-Ary Tree](https://leetcode.com/problems/diameter-of-n-ary-tree)  
   Need to keep two largest depth of children
   <details>

   ```python
   for child in node.children:
       childDepth = getDepth(child)
       if childDepth > maxDepth:
           secondMaxDepth = maxDepth
           maxDepth = childDepth
       elif childDepth > secondMaxDepth:
           secondMaxDepth = childDepth
   ```
   </details>
1. [236. Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree)  
   ***A key restraint is p and q must exist***
    User recruision, at each step
   1. If node is Null, then neither p or q can be in that tree, return null
   1. Or if the current (sub)tree contains both p and q, then the node their LCA. 
   1. Or both subtree contains p or q, then the node is their LCA
   1. Or only one of them is in that subtree, return LCA from that subtree. 
   <details>      
   
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
   </details>
1. [1644. Lowest Common Ancestor of a Binary Tree II](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii)  
   P and q are not guaranteed to exist, so always need to explore both left and right tree, and mark whether p or q has been found
   <details>

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

   </details>
1. [235. Lowest Common Ancestor of a Binary Search Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree)  
   If both are greater than root, then search right subtree, or both are smaller than root then search left subtree, otherwise return root
   Start traversing the tree from the root node.
   1. If root is null, then no common LCA, return null
   1. If either p or q is root, return root is LCA
   1. If both the nodes p and q are in the right subtree, then continue the search with right subtree
   1. If both the nodes p and q are in the left subtree, then continue the search with left subtree
   1. If both step 2 and step 3 are not true, this means we have found the node which is common to node p's and q's subtrees.and hence we return this common node as the LCA.
   <details>
   
   ```python
        def getLCA(node, p, q):
            if not node:
                return None

            if node == p or node == q:
                return node

            if p.val > node.val and q.val > node.val:
                return getLCA(node.right, p, q)
            elif p.val < node.val and q.val < node.val:
                return getLCA(node.left, p, q)
            else:
                return node 
   ```
   </details>
1. [1676. Lowest Common Ancestor of a Binary Tree IV](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iv)  
   Similar to 236, except there are multiple nodes, convert it to a set for easy check
   ```python
   if not root or root in nodes:
       return root
   ```
1. [105. Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal)  
   Find the root value from preorder, and then find its position in inorder, then find inorder and preorder of left and right subtree  
   Time complexity O(N), space complexity O(H)
   <details>
      
      ```python
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder:
            return None
        
        root = TreeNode(preorder[0])
        separatorIdx = inorder.index(root.val)
        inorderLeft = inorder[:separatorIdx]
        inorderRight = inorder[separatorIdx + 1 : ]
        preorderLeft = preorder[1 : 1 + len(inorderLeft)]
        preorderRight = preorder[1 + len(inorderLeft) : ]
        root.left = self.buildTree(preorderLeft, inorderLeft)
        root.right = self.buildTree(preorderRight, inorderRight)
        return root
      ```      
   </details>
1. [106. Construct Binary Tree from Inorder and Postorder Traversal](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iv)  
   Find the root value from postorder, and then find its position in inorder, then find inorder and postorder of left and right subtree  
   Time complexity O(N), space complexity O(H)
   <details>
      
      ```python
          def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
           if not inorder:
               return None
   
           root = TreeNode(postorder[-1])
           separatorIdx = inorder.index(root.val)
           inorderLeft = inorder[: separatorIdx]
           inorderRight = inorder[separatorIdx + 1 :]
           postorderLeft = postorder[:len(inorderLeft)]
           postorderRight = postorder[len(inorderLeft) : len(postorder) - 1]
           root.left = self.buildTree(inorderLeft, postorderLeft)
           root.right = self.buildTree(inorderRight, postorderRight)
           return root
      ```      
   </details>

## Hard
1. [297. Serialize and Deserialize Binary Tree](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal)  
   ***Preorder traversal. Need to memorize the code***
   <details>

   ```python
    def serialize(self, root):
        result = []
        def dfs(root):
            if not root:
                result.append("X")
                return
            result.append(str(root.val))
            dfs(root.left)
            dfs(root.right)
        
        dfs(root)
        return " ".join(result)
        

    def deserialize(self, data):
        def dfs(nodes):
            val = next(nodes)
            if val == "X":
                return
            
            root = TreeNode(val)
            root.left = dfs(nodes)
            root.right = dfs(nodes)
            return root
        return dfs(iter(data.split(" ")))
   ```
   </details>

