
# Backtrack
1. [77. Combinations](https://leetcode.com/problems/combinations)  
   Key is to increase the start point in each recursion
     <details>
    
    ```python
            for i in range(start, n + 1):
                path.append(i)
                backtrack(i + 1, path, result)
                path.pop()
    ```
   </details>
1. [113. Path Sum II](https://leetcode.com/problems/path-sum-ii)  
  Need to use backtrack as result is all the paths.
  Time complexity is O(N^2) as O(N) for traversing nodes and O(N) for copying path
    <details>

        def dfs(node, targetSum, path, result):
            if not node:
                return
            
            path.append(node.val)
            if node.left is None and node.right is None and node.val == targetSum:
                result.append(path[:])
            
            nextTargetSum = targetSum - node.val
            dfs(node.left, nextTargetSum, path, result)
            dfs(node.right, nextTargetSum, path, result)

            path.pop()

        result = []
        dfs(root, targetSum, [], result)
        return result   
    </details>
  
1. [129. Sum Root to Leaf Numbers](https://leetcode.com/problems/sum-root-to-leaf-numbers)  
   Need to use backtrack as result is total sum of all root-to-leaf paths.
   <details>

    ```python
        total = 0
        def dfs(node, pathSum):
            if node is None:
                return
                
            nonlocal total
            nextPathSum = pathSum * 10 + node.val
            if node.left is None and node.right is None:
                total += nextPathSum
            
            dfs(node.left, nextPathSum)
            dfs(node.right, nextPathSum)

        dfs(root, 0)
        return total
    ```
   </details>
1. [257. Binary Tree Paths](https://leetcode.com/problems/binary-tree-paths)  
  Need to use backtrack as result is all the paths.
  Time complexity is O(N^2) as O(N) for traversing nodes and O(N) for copying path
    <details>

    ```python
          def backtrack(node, path, result):
              if node is None:
                  return
  
              path.append(str(node.val))
              if node.left is None and node.right is None:
                  result.append("->".join(path))
              
              backtrack(node.left, path, result)
              backtrack(node.right, path, result)
  
              path.pop()
  
          result = []
          backtrack(root, [], result)
          return result
    ```
    </details>

1. [1022. Sum of Root To Leaf Binary Numbers](https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers)  

