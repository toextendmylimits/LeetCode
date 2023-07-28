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
