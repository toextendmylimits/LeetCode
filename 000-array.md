# Array
1. [217. Contains Duplicate](https://leetcode.com/problems/contains-duplicate)    
    ***Approach 1 - Use hash set***
    <details>

      ```python
       def containsDuplicate(self, nums: List[int]) -> bool:
           seen = set()
           for n in nums:
               if n in seen:
                   return True
               else:
                   seen.add(n)
           
           return False
      ```
    </details>
    
    ***Approach 2 - Sort first, and then check whether any element equal to previous one starting from second element***
    <details>

      ```python
       def containsDuplicate(self, nums: List[int]) -> bool:
           nums.sort()
           for i in range(1, len(nums)):
               if nums[i] == nums[i - 1]:
                   return True
   
           return False
      ```
    </details>
    
1. [189. Rotate Array](https://leetcode.com/problems/rotate-array)  
    ***Approach 1 - Have an auxiliary array, aux[(i + k ) % len(nums)] = nums[i], and assign aux to original array***
    <details>

      ```python
        def rotate(self, nums: List[int], k: int) -> None:
            aux = [0] * len(nums)
            for i in range(len(nums)):
                aux[(i + k) % len(nums)] = nums[i]
            
            for i in range(len(nums)):
                nums[i] = aux[i]
      ```
    </details>
    
    ***Approach 2 - Reverse 3 times***
    <details>

      ```python
        def rotate(self, nums: List[int], k: int) -> None:
            def reverse(start, end):
                left = start
                right = end
                while left < right:
                    nums[left], nums[right] = nums[right], nums[left]
                    left += 1
                    right -= 1
                    
            k %= len(nums)
            reverse(0, len(nums) - 1)
            reverse(0, k - 1)
            reverse(k, len(nums) - 1)
      ```
    </details>
1. [66. Plus One](https://leetcode.com/problems/plus-one)  
    Copy existing array to a new one.   
    1. Starting from the last element of the array, add the digit and 1 or carry.   
    1. If total is less than 10, assign the number to result array and return immeditately
    1. If total is equal or greater than 10(It can't be greater than 10 in fact), assign 0 to the result, and set carry to 1
    1. In the end, if carry is 1, return 1 + [0] * len
    <details>

      ```python
      def plusOne(self, digits: List[int]) -> List[int]:
          carry = 0
          result = digits[:]
          for i in range(len(digits) - 1, -1, -1):
              total = digits[i] + (1 if i == len(digits) - 1 else carry)
              if total < 10:
                  result[i] = total
                  return result
              else:
                  result[i] = 0
                  carry = 1
  
          if carry == 1:
              return [1] + [0] * len(digits)
      ```
    </details>

1. [350. Intersection of Two Arrays II](https://leetcode.com/problems/intersection-of-two-arrays-ii)  
   ***Approach 1 is use hash map*** to save number and its frequency for a smaller array, and then scan another array, if its frequency is greater than 0, append to result, and then decrease frequency
     
    ***Approach 2 is to sort both arrays, and then use two pointers***, when num not equal, advance pointer for lower number, and when equal, append element to result, and advance both pointer  
    Time complexity is O(NlogN + MlogM), space complexity is O(logN + logM) to O(N+M) depends on the sorting algorithm    
    <details>

      ```python
        counter = Counter(nums1)
        result = []
        for n in nums2:
            if counter[n] > 0:
                result.append(n)
                counter[n] -= 1

        return result
      ```
      
      ```python
        def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
            nums1.sort()
            nums2.sort()
            result = []
            i = 0
            j = 0
            while i < len(nums1) and j < len(nums2):
                if nums1[i] < nums2[j]:
                    i += 1
                elif nums1[i] > nums2[j]:
                    j += 1
                else:
                    result.append(nums1[i])
                    i += 1
                    j += 1
            return result      
      ```
    </details>
1. [88. Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array)  
   Start from the end, and try to fill the array with large elment of the two arrays. If the end, if array2 still has elements, fill the rest of the result array
    <details>

      ```python
        def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
            i = m - 1
            j = n - 1
            k = m + n - 1
            while i >= 0 and j >= 0:
                if nums1[i] > nums2[j]:
                    nums1[k] = nums1[i]
                    i -= 1
                else:
                    nums1[k] = nums2[j]
                    j -= 1
                k -= 1
            
            while j >= 0:
                nums1[k] = nums2[j]
                j -= 1
                k -= 1
      ```
    </details>   
1. [163. Missing Ranges](https://leetcode.com/problems/missing-ranges)  
    1. If nums is empty, return range [lower, upper]
    1. If lower < first num, then there is missing range [lower, first num - 1]
    1. Starting from second num, whether the num is greater than previous num by more than 1, then there is missing range [prev num + 1, num - 1]  
    1. If upper is greater than last num, then there is missing range [last num + 1, upper]   
    <details>

      ```python
        def findMissingRanges(self, nums: List[int], lower: int, upper: int) -> List[List[int]]:
            if not nums:
                return [[lower, upper]]
    
            result = []
            if lower < nums[0]:
                result.append([lower, nums[0] - 1])
            
            for i in range(1, len(nums)):
                if nums[i] - nums[i - 1] > 1:
                    result.append([nums[i - 1] + 1, nums[i] - 1])
            
            if upper > nums[-1]:
                result.append([nums[-1] + 1, upper])
            
            return result
      ```
    </details>   

1. [238. Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self)   
    ***Approach 1 - Use array pre to store products of left, suff to store products of right*** 
    <details>

      ```python
        def productExceptSelf(self, nums: List[int]) -> List[int]:
            size = len(nums)
            pre = [0] * size
            suff = [0] * size
            pre[0] = 1
            suff[-1] = 1
            
            for i in range(1, size):
                pre[i] = pre[i - 1] * nums[i - 1]
            
            for i in range(size - 2, -1, -1):
                suff[i] = suff[i + 1] * nums[i + 1]
            
            result = [0] * size
            for i in range(size):
                result[i] = pre[i] * suff[i]
            
            return result
      ```
    </details>   

    ***Approach 2 - Use out put array as prefix, and construct the suff on the fly*** 
    <details>

      ```python
        def productExceptSelf(self, nums: List[int]) -> List[int]:
            size = len(nums)
            result = [1] * size
    
            for i in range(1, len(nums)):
                result[i] = result[i - 1] * nums[i - 1]
            
            rightProduct = 1
            for i in range(len(nums) - 1, -1, -1):
                result[i] *= rightProduct
                rightProduct *= nums[i]
            
            return result
      ```
    </details>   

    
## Two-dimensional array/matrix
1. [54. Spiral Matrix](https://leetcode.com/problems/spiral-matrix)   
    Set up the boundaries top, right, bottom, left  
    Loop if the result array is not fully filled, in each iteration:  
    1. Traverse from top -> right -> bottom -> left
    1. Then change the bondary
    <details>

      ```python
        def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
            rowCount = len(matrix)
            colCount = len(matrix[0])
            result = [0] * (rowCount * colCount) 
            topRow = 0
            bottomRow = rowCount - 1
            leftCol = 0
            rightCol = colCount - 1
            i = 0
            while i < rowCount * colCount:
                for c in range(leftCol, rightCol + 1):
                    if i < rowCount * colCount:
                        result[i] = matrix[topRow][c]
                        i += 1
                
                for r in range(topRow + 1, bottomRow + 1):
                    if i < rowCount * colCount:
                        result[i] = matrix[r][rightCol]
                        i += 1
                
                for c in range(rightCol - 1, leftCol - 1, -1):
                    if i < rowCount * colCount:
                        result[i] = matrix[bottomRow][c]
                        i += 1
    
                for r in range(bottomRow - 1, topRow, -1):
                    if i < rowCount * colCount:
                        result[i] = matrix[r][leftCol]
                        i += 1
                
                topRow += 1
                bottomRow -= 1
                leftCol += 1
                rightCol -= 1
    
            return result
      ```
    </details>

1. [36. Valid Sudoku](https://leetcode.com/problems/valid-sudoku)     
    A valid sudoku board should satisfy three conditions: (1) each row, (2) each column, and (3) each box has no duplicate numbers.  
    We create a set for each row, column and box.  
    Difficult is to identify each box, r // 3 * 3 + c // 3  

    Steps:
    1. Initialize a list of hash set for each row, column and box
    2. Iterate over each position, and check whether the number in the hash set for each row, column, or box, if so, return False, otherwise add to set  
    3. In the end, return True  

    ***Both time complexity and space complexity is O(N ^ 2)***
    <details>

      ```python
       def isValidSudoku(self, board: List[List[str]]) -> bool:
           size = len(board)
           rowSet = [set() for _ in range(size)]
           colSet = [set() for _ in range(size)]
           boxSet = [set() for _ in range(size)]
           for r in range(size):
               for c in range(size):
                   cell = board[r][c]
                   if cell == ".":
                       continue
                   
                   if cell in rowSet[r]:
                       return False
                   rowSet[r].add(cell)
   
                   if cell in colSet[c]:
                       return False
                   colSet[c].add(cell)
   
                   boxId = r // 3 * 3 + c // 3
                   if cell in boxSet[boxId]:
                       return False
                   boxSet[boxId].add(cell)
           
           return True
      ```
    </details>

1. [48. Rotate Image](https://leetcode.com/problems/rotate-image)       
    Transpose and reflect  

    <details>

      ```python
       def rotate(self, matrix: List[List[int]]) -> None:
           """
           Do not return anything, modify matrix in-place instead.
           """
           def transpose():
               for r in range(len(matrix)):
                   for c in range(r + 1, len(matrix[0])):
                       matrix[r][c], matrix[c][r] = matrix[c][r], matrix[r][c]
   
           def reflect():
               for r in range(len(matrix)):
                   for c in range(len(matrix[0]) // 2):
                       matrix[r][c], matrix[r][len(matrix[0]) -1 - c] = matrix[r][len(matrix[0]) -1 - c], matrix[r][c]
           
           transpose()
           reflect()
      ```
    </details>

1. [73. Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes)         
    Use first row and column to indicate whether a row or column should be marked as zero  
    Given first row or column is used, need two boolean flags to indicate whether first row or column should also be marked as zero  

    <details>

      ```python
       def setZeroes(self, matrix: List[List[int]]) -> None:
           rowsCount = len(matrix)
           colsCount = len(matrix[0])
           doesFirstRowHaveZero = False
           doesFirstColHaveZero = False
           for r in range(rowsCount):
               if matrix[r][0] == 0:
                   doesFirstColHaveZero = True
                   break
           
           for c in range(colsCount):
               if matrix[0][c] == 0:
                   doesFirstRowHaveZero = True
                   break
           
           for r in range(1, rowsCount):
               for c in range(1, colsCount):
                   if matrix[r][c] == 0:
                       matrix[0][c] = 0
                       matrix[r][0] = 0
           
           for r in range(1, rowsCount):
               for c in range(1, colsCount):
                   if matrix[0][c] == 0 or matrix[r][0] == 0:
                       matrix[r][c] = 0
           
           if doesFirstRowHaveZero:
               for c in range(colsCount):
                   matrix[0][c] = 0
   
           if doesFirstColHaveZero:
               for r in range(rowsCount):
                   matrix[r][0] = 0    
      ```
    </details>
