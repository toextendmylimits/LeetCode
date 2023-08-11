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
   ***Time complexity O(logMN), space complexity O(1)
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

   ## Not binary search, but is similar in the sense search scope can be narrowed down quickly
