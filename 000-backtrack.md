
# Backtrack
1. [77. Combinations](https://leetcode.com/problems/combinations)  
   Note candidates have no duplicate and a candidate can only be used once in a combination
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
   Notice the candidates are ***distinct***, but the same number may be chosen from candidates an **unlimited number of times**. This is important as it means the start point for next recursion call is i instead of i + 1 as in classcial combination problem where no duplication is allowed  
  
   We can incrementally build the combination, and once we find the current combination is not valid, we backtrack and try another option.
      
   ***Complexity:***
   Let N be the number of candidates, T be the target value, and M be the minimal value among the candidates.
   
   Time Complexity: O(N^(T/M+1) as there are at most O(N^(T/M)) combinations, and copy the combination could take O(N)  
   Space Complexity: O(T/M)  
   1. The number of recursive calls can pile up to O(T/M) , where we keep on adding the smallest element to the combination.
   As a result, the space overhead of the recursion is O(T/M) )
   1. We keep a combination of numbers during the execution, which requires at most O(T/M) space as well.   
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
1. [40. Combination Sum II](https://leetcode.com/problems/combination-sum-ii)  
   Notice the candidates are **NOT distinct**, but the same candidate can only be chosen once. This is important as it means the start point for next recursion call is i + 1
   Also the candidates need to be sorted to help avoid duplicating combinations
  
   We can incrementally build the combination, and once we find the current combination is not valid, we backtrack and try another option.
      
   ***Complexity:***     
   Time Complexity: O(2^N*N) as there are at most O(2^N)) combinations, and copy the combination could take O(N)  
   Space Complexity: O(N)  
   1. The number of recursive calls can pile up to O(N), where we keep on adding the smallest element to the combination.
   As a result, the space overhead of the recursion is O(N) 
   1. We keep a combination of numbers during the execution, which requires at most O(N)  space as well.   
     <details>
    
    ```python
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()

        result = []
        def backtrack(startIndex, remain, path):
            nonlocal candidates, result
            if remain == 0:
                result.append(path[:])
                return

            if remain < 0:
                return

            for i in range(startIndex, len(candidates)):
                if i > startIndex and candidates[i] == candidates[i - 1]:
                    continue
                path.append(candidates[i])
                backtrack(i + 1, remain - candidates[i], path)
                path.pop()
        backtrack(0, target, [])
        return result
            
    ```
   </details> 
1. [78. Subsets](https://leetcode.com/problems/subsets)  
  Notice the numbers ***DOES NOT contain duplicates***   
  Time complexity is O(2^N*N) as O(2^N) as there are O(2^N) subsets and O(N) for copying path
    <details>

      ```python
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        def backtrack(startIndex, path):
            nonlocal nums, result

            result.append(path[:])

            for i in range(startIndex, len(nums)):
                path.append(nums[i])
                backtrack(i + 1, path)
                path.pop()

        backtrack(0, [])
        return result

      ``` 
    </details> 
1. [90. Subsets II](https://leetcode.com/problems/subsets-ii)  
  Notice the numbers ***contain duplicates***, so need to sort the numbers first  
  Time complexity is O(2^N*N) as O(2^N) as there are O(2^N) subsets and O(N) for copying path
    <details>

      ```python
       def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
           nums.sort()
           result = []
   
           def backtrack(startIndex, path):
               nonlocal nums, result
   
               result.append(path[:])
   
               for i in range(startIndex, len(nums)):
                   if i > startIndex and nums[i] == nums[i - 1]:
                       continue
   
                   path.append(nums[i])
                   backtrack(i + 1, path)
                   path.pop()
   
           backtrack(0, [])
           return result

      ``` 
    </details>  
1. [46. Permutations](https://leetcode.com/problems/permutations)  
  Need to use an array to keep track of whether a number has been visited
  Time complexity is O(N!*N) as O(N!) as there are O(N!) permuation and O(N) for copying path
    <details>

      ```python
       def permute(self, nums: List[int]) -> List[List[int]]:
           used = [False] * len(nums)
           result = []
           def backtrack(path):
               nonlocal nums, used, result
               if len(path) == len(nums):
                   result.append(path[:])
                   return
   
               for i in range(len(nums)):
                   if used[i]:
                       continue
                   
                   used[i] = True
                   path.append(nums[i])
                   backtrack(path)
                   path.pop()
                   used[i] = False
           backtrack([])
           return result
      ``` 
    </details>  

1. [47. Permutations II](https://leetcode.com/problems/permutations-ii/)  
  Notice the numbers ***contains duplicates***, so it's important to avoid duplication  
  Time complexity is O(N!*N) as O(N!) as there are O(N!) permuation and O(N) for copying path
    <details>

      ```python
       def permuteUnique(self, nums: List[int]) -> List[List[int]]:
           nums.sort()
           used = [False] *(len(nums))
           result = []
   
           def backtrack(path):
               nonlocal nums, used, result
   
               if len(path) == len(nums):
                   result.append(path[:])
                   return
   
               for i in range(len(nums)):
                   if i > 0 and nums[i] == nums[i - 1] and not used[i - 1]:
                       continue
   
                   if used[i]:
                       continue
   
                   used[i] = True
                   path.append(nums[i])
                   backtrack(path)
                   used[i] = False
                   path.pop()
           backtrack([])
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
   Time complexity: O(N) since one has to visit each nodr where N is number of nodes   
   Space complexity: O(H) for stack call while H is height of tree. In worst case, it's O(N)    
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
Time complexity: O(N) since one has to visit each nodr where N is number of nodes 
Space complexity: O(H) for stack call while H is height of tree. In worst case, it's O(N)  

1. [22. Generate Parentheses](https://leetcode.com/problems/generate-parentheses/)  
   Need to maintain the count of left parenthesis and right parenthesis
  Time complexity is O(2^2N * N) as O(2^2N) for all possible combinations and O(N) for copying each combination
    <details>

    ```python
    def generateParenthesis(self, n: int) -> List[str]:
        result = []
        def backtrack(open, close, path):
            nonlocal result, n

            if open + close == 2 * n:
                result.append("".join(path))
                return

            if open < n:
                path.append("(")
                backtrack(open + 1, close, path)
                path.pop()

            if close < open:
                path.append(")")
                backtrack(open, close + 1, path)
                path.pop()

        backtrack(0, 0, [])
        return result
    ```
    </details>
1. [17. Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number)  
   No need to maintain start position in each iteration which is common for combination problem, as the the length of path is essentially the start point  
   Time complexity is O(4^N * N) as O(4^N ) for all possible combinations and O(N) for copying each combination  
   Space complexity is O(N)  
   ***Also notice edge case when the digits array has no element, return [] instead of [""]***  
    <details>

    ```python
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []

        digitLetterMap = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
        result = []
        def backtrack(path):
            nonlocal digits, digitLetterMap, result

            if len(path) == len(digits):
                result.append("".join(path))
                return

            digit = int(digits[len(path)])
            letters = digitLetterMap[digit]
            for letter in letters:
                path.append(letter)
                backtrack(path)
                path.pop()

        backtrack([])
        return result
    ```
    </details>
1. [784. Letter Case Permutation](https://leetcode.com/problems/letter-case-permutation)  
   No need to maintain start position in each iteration which is common for combination problem, as the the length of path is essentially the start point  
   Time complexity is O(2^N * N) as O(2^N ) for all possible combinations and O(N) for copying each combination  
   Space complexity is O(N)  
   Also notice edge case when the digits array has no element, return [] instead of [""]  
    <details>

    ```python
    def letterCasePermutation(self, s: str) -> List[str]:
        result = []
        def backtrack(path):
            nonlocal s, result

            if len(path) == len(s):
                result.append("".join(path))
                return

            letter = s[len(path)]
            if  letter.isalpha():
                for ch in [letter.lower(), letter.upper()]:
                    path.append(ch)
                    backtrack(path)
                    path.pop()
            else:
                path.append(letter)
                backtrack(path)
                path.pop()               
        backtrack([])
        return result
    ```
    </details>
    
1. [491. Non-decreasing Subsequences](https://leetcode.com/problems/non-decreasing-subsequences)  
   ***Can't sort the array as otherwise there will be many more wrong sequences***  
   ***Also the set to avoid duplication is created inside of the recursive backtrack function***  
   Time complexity is O(2^N * N) as O(2^N ) for all possible combinations and O(N) for copying each combination
   Space complexity is O(N)  
    <details>

       ```python
       def findSubsequences(self, nums: List[int]) -> List[List[int]]:
           result = []
           def backtrack(startIndex, path):
               nonlocal nums, result
   
               if len(path) >= 2:
                   result.append(path[:])
   
               used = set()
               for i in range(startIndex, len(nums)):
                   if (path and nums[i] < path[-1]) or nums[i] in used:
                       continue
     
                   used.add(nums[i])
                   path.append(nums[i])
                   backtrack(i + 1, path)
                   path.pop()
           backtrack(0, [])
           return result
       ```
    </details>
1. [131. Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning)  
   Each step, partition the substrings from start position to all possible end positions
   Time complexity is O(2^N * N) as O(2^N ) for all possible substrings(Each letter can be in the list of substrings or not), and O(N) for copying each combination
   Space complexity is O(N)  
    <details>

       ```python
       def partition(self, s: str) -> List[List[str]]:
           def isPalindrome(s):
               return s == s[::-1]
   
           result = []
           def backtrack(start, path):
               nonlocal s, result
   
               if start == len(s):
                   result.append(path[:])   
                   return
   
               for end in range(start + 1, len(s) + 1):
                     prefix = s[start : end]
                     if isPalindrome(prefix):
                         path.append(prefix)
                         backtrack(end, path)
                         path.pop()
           backtrack(0, [])
           return result
       ```
    </details>
