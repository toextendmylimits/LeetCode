
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
