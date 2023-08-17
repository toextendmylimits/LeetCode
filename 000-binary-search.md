# Binary Search
1. [704. Binary Search](https://leetcode.com/problems/binary-search)  
   <details>
      
    ```python
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                right = mid -1
            else:
                left = mid + 1
        return -1
    ```
   </details>

1. [34. Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array)
   <details>
      
    ```python
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def findFirst(nums, target):
            left = 0
            right = len(nums) - 1
            result = -1
            while left <= right:
                mid = left + (right - left) // 2
                if nums[mid] == target:
                    result = mid
                    right = mid - 1
                elif nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1
            return result
        
        def findLast(nums, target):
            left = 0
            right = len(nums) - 1
            result = -1
            while left <= right:
                mid = left + (right - left) // 2
                if nums[mid] == target:
                    result = mid
                    left = mid + 1
                elif nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1
            return result
        
        return [findFirst(nums, target), findLast(nums, target)]
    ```
   </details>   
1. [33. Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array)  
   If seperate the arary by mid, then at least one half is sorted, so binary search can be used if target is in the sorted half.
   1. If left half is sorted, i.e. nums[left] <= nums[mid], then if target is within the left half,, then right = mid - 1 else left = mid + 1  
   1. Otherwise right half is sorted, i.e. nums[left] > nums[mid], then if target is within right half, then left = mid + 1 else right - mid - 1  
   <details>
      
    ```python
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] >= nums[left]:
                if target >= nums[left] and target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                if target > nums[mid] and target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
        return -1
    ```
   </details>

1. [74. Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix)  
   The input matrix m x n could be considered as a sorted array of length m x n. The element index can be transformed to row and col, row = index / number of columns, and col = index % number of columns  
   ***Time complexity O(logMN), space complexity O(1)***
   <details>
      
    ```python
       def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
           m = len(matrix)
           n = len(matrix[0])
           left = 0
           right = m * n - 1
           while left <= right:
               mid = left + (right - left) // 2
               row = mid // n
               col = mid % n
               if matrix[row][col] == target:
                   return True
               elif matrix[row][col] > target:
                   right = mid - 1
               else:
                   left = mid + 1
           return False
    ```
   </details>
1. [162. Find Peak Element](https://leetcode.com/problems/find-peak-element/)  
   ***Approach 1*** - Linear search to check whether next element is smaller than current element, if so, return index  
   In the end, return last index
   <details>
      
    ```python
       def findPeakElement(self, nums: List[int]) -> int:
           for i in range(len(nums) - 1):
               if nums[i] > nums[i + 1]:
                   return i
           
           return len(nums) - 1
    ```
   </details>  

   ***Approach 2*** - Binary search if next element of mid is smaller than mid, or mid is last, save mid as result, and searh on left by decreasing right by 1, otherwise search on right by increasing left by 1  
   In the end, return last index
   <details>
      
    ```python
       def findPeakElement(self, nums: List[int]) -> int:
           left = 0
           right = len(nums) - 1
           result = -1
           while left <= right:
               mid = left + (right - left) // 2
               if mid == len(nums) - 1 or nums[mid] > nums[mid + 1]:
                   result = mid
                   right = mid - 1
               else:
                   left = mid + 1
           return result
    ```
   </details>

1. [69. Sqrt(x)](https://leetcode.com/problems/sqrtx)  
   <details>
      
    ```python
       def mySqrt(self, x: int) -> int:
           if x == 0:
               return 0
   
           if x < 4:
               return 1
           
           left = 2
           right = x
           result = 2
           while left <= right:
               mid = left + (right - left) // 2
               if mid <= x // mid:
                   result = mid
                   left = mid + 1
               else:
                   right = mid - 1
   
           return result
    ```
   </details>
## Not binary search, but is similar in the sense search scope can be narrowed down quickly
1. [240. Search a 2D Matrix II](https://leetcode.com/problems/search-a-2d-matrix-ii)   
   We start search the matrix from top right corner, initialize the current position to top right corner, if the target is greater than the value in current position, then the target can not be in entire row of current position because the row is sorted, if the target is less than the value in current position, then the target can not in the entire column because the column is sorted too
     
   ***We can rule out one row or one column each time, so the time complexity is O(m+n).***
   <details>
      
    ```python
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        row = 0
        col = len(matrix[0]) - 1
        while row < len(matrix) and col >= 0:
            if matrix[row][col] == target:
                return True
            elif matrix[row][col] > target:
                col -= 1
            else:
                row += 1
        return False
    ```
   </details>
