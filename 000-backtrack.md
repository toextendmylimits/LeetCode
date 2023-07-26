
# Backtrack
1. [77. Combinations](https://leetcode.com/problems/combinations)  
   Note candiates have no duplicate and a candidate can only be used once in a combination
   Key is to increase the start point in each recursion
     <details>
    
    ```python
            for i in range(start, n + 1):
                path.append(i)
                backtrack(i + 1, path, result)
                path.pop()
    ```
   </details>
1. [216. Combination Sum III](https://leetcode.com/problems/combination-sum-iii)  
   Return if path length equal to count of numbers, increase start point in each recursion, and prune if remaining sum is less than 0
   <details>

   ```python
            if targetSum < 0:
                return

            if len(path) == k:
                if targetSum == 0:
                    result.append(path[:])
                return

            for i in range(start, 10):
                path.append(i)
                backtrack(i + 1, targetSum - i, path, result )
                path.pop()
   ```
   </details>
1. [39. Combination Sum](https://leetcode.com/problems/combination-sum)  
   Notice the same number may be chosen from candidates an **unlimited number of times**. This is important as it means the start point for next recursion call is i instead of i + 1 as in classcial combination problem where no duplication is allowed  
  
   We can incrementally build the combination, and once we find the current combination is not valid, we backtrack and try another option.
      
   ***Complexity:***
   Let N be the number of candidates, T be the target value, and M be the minimal value among the candidates.
   
   Time Complexity: O(N^(T/M+1) as there are at most O(N^(T/M)) combinations, and copy the combination could take O(N)  
   Space Complexity: O(N^(T/M))  
   1. The number of recursive calls can pile up to O(N^(T/M)), where we keep on adding the smallest element to the combination.
   As a result, the space overhead of the recursion is O(N^(T/M))
   1. We keep a combination of numbers during the execution, which requires at most O(N^(T/M)) space as well.   
     <details>
    
    ```python
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []
        def backtrack(startIndex, remain, path):
            nonlocal candidates, result
            if remain == 0:
                result.append(path[:])
                return
            
            if remain < 0:
                return

            for i in range(startIndex, len(candidates)):
                path.append(candidates[i])
                backtrack(i, remain - candidates[i], path)
                path.pop()

        backtrack(0, target, [])
        return result
            
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

