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

1. [153. Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array)  
   If mid is smaller than last element, then save it and go left as all the right elements will be larger; Else go right
   <details>
      
    ```python
    def findMin(self, nums: List[int]) -> int:      
        left = 0
        right = len(nums) - 1
        result = -1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] <= nums[-1]:
                result = nums[mid]
                right = mid - 1
            else:
                left = mid + 1

        return result
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
    # Check mid == 0 or nums[mid] > nums[mid - 1]
    def findPeakElement(self, nums: List[int]) -> int:
        left = 0
        right = len(nums) - 1
        result = -1
        while left <= right:
            mid = left + (right - left) // 2
            if mid == 0 or nums[mid] > nums[mid - 1]:
                result = mid
                left = mid + 1
            else:
                right = mid - 1
                
        return result
    
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

1. [540. Single Element in a Sorted Array](https://leetcode.com/problems/single-element-in-a-sorted-array)  
   Key observation is the array with odd element's length should be odd. So if we find a pair that has same elements, then the single element is on either its left side or right side depends on which side has odd length. The pair can be either (mid, mid + 1) or (mid - 1, mid).  
   <details>
      
    ```python
    def singleNonDuplicate(self, nums: List[int]) -> int:
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if mid + 1 < len(nums) and nums[mid + 1] == nums[mid]:
                if (mid - left) % 2 == 0:
                    left = mid + 2
                else:
                    right = mid - 1
            elif mid >= 1 and nums[mid - 1] == nums[mid]:
                if (mid - 1 - left) % 2 == 0:
                    left = mid + 1
                else:
                    right = mid - 2
            else:
                return nums[mid]

    ```
   </details>

1. [875. Koko Eating Bananas](https://leetcode.com/problems/koko-eating-bananas)    
   The eating speed must be somewhere between 1 and max(piles). The time needed to east one pile is math.ceil(pile / eating speed). Use binary search.   
   <details>
      
    ```python
   def minEatingSpeed(self, piles: List[int], h: int) -> int:
        def get_eat_time(piles, speed):
            total = 0
            for pile in piles:
                total += math.ceil(pile / speed)
            return total
            
        left = 1
        right = max(piles)
        result = -1
        while left <= right:
            mid = left + (right - left) // 2
            eat_time = get_eat_time(piles, mid)
            if eat_time <= h:
                result = mid
                right = mid - 1
            else:
                left = mid + 1

        return result

    ```
   </details>

1. [441. Arranging Coins](https://leetcode.com/problems/arranging-coins)   
   The eating speed must be somewhere between 1 and max(piles). The time needed to east one pile is math.ceil(pile / eating speed). Use binary search.   
   <details>
      
    ```python
    def arrangeCoins(self, n: int) -> int:
        row = 1
        n -= row

        while n >= 0:
            row += 1
            n -= row
        
        return row - 1
        
    # Binary Search
    def arrangeCoins(self, n: int) -> int:
        left = 1
        right = n
        result = -1
        while left <= right:
            mid = left + (right - left) // 2
            if mid * (mid + 1) <= 2 * n:
                result = mid
                left = mid + 1
            else:
                right = mid - 1
        return result
    ```
   </details>

1. [1011. Capacity To Ship Packages Within D Days](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days) 
   The capacity must be less than the total weights but greater than the maximum weight. 

   1. In the is_capacity_enough method, initially have needed days as 1, and total weight as 0. Then linear scan the weights, for each weight  
   1. add it to total weight, if the total weight is greater than capacity, then another day is needed, and reset the total weight for this day.   
   1. If needed days are greater than the days, return False  
   1. In the end, return True  
   <details>
      
    ```python
   def shipWithinDays(self, weights: List[int], days: int) -> int:
        def is_capacity_enough(weights, capacity, days):
            days_needed = 1
            total_weight = 0
            for weight in weights:
                total_weight += weight
                if total_weight > capacity: 
                    days_needed += 1
                    total_weight = weight
                    if days_needed > days:
                        return False
            return True

        left = max(weights)
        right = sum(weights)
        result = -1
        while left <= right:
            mid = left + (right - left) // 2
            if is_capacity_enough(weights, mid, days):
                result = mid
                right = mid - 1
            else:
                left = mid + 1
        
        return result
    ```
   </details>
   
## Difficult
1. [1539. Kth Missing Positive Number](https://leetcode.com/problems/kth-missing-positive-number)  
   ***Approach 1. Iterate over the array and compute the number of missing numbers in-between the elements.***    
   <details>
      
    ```python
       def findKthPositive(self, arr: List[int], k: int) -> int:
           if k <= arr[0] - 1:
               return k
           
           k -= arr[0] - 1
   
           for i in range(len(arr) - 1):
               currMissing = arr[i + 1] - arr[i] - 1
               if k <= currMissing:
                   return arr[i] + k
               else:
                   k -= currMissing
           
           return arr[-1] + k
    ```
   </details>

   ***Approach 2. Binary Search***  
   Key observation is that The number of positive integers which are missing before the arr[idx] is equal to arr[idx] - idx - 1.   
   <details>
      
    ```python
       def findKthPositive(self, arr: List[int], k: int) -> int:
           left = 0
           right = len(arr) - 1
           while left <= right:
               mid = left + (right - left) // 2
               if arr[mid] - mid - 1 < k:
                   left = mid + 1
               else:
                   right = mid - 1
           
           return left + k
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
