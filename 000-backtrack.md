
# Backtrack
1. [113. Path Sum II](https://leetcode.com/problems/path-sum-ii)
  Need to use backtrack as result is all the paths
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
