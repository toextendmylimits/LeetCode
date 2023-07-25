# Slidng window
1. [209. Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum)  
    <details>

      ```python
        def minSubArrayLen(self, target: int, nums: List[int]) -> int:
            result = len(nums) + 1
            total = 0
            start = 0
    
            for end in range(len(nums)):
                total += nums[end]
    
                while total >= target:
                    result = min(result, end - start + 1)
                    total -= nums[start]
                    start += 1
            return 0 if result == len(nums) + 1 else result
      ```
    </details>
1. [713. Subarray Product Less Than K](https://leetcode.com/problems/subarray-product-less-than-k)  
   Note that the Sliding window approach is only valid because numbers are positive.
   Once find a valid window, increase the count by right - left + 1  
    <details>

      ```python
        def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
            if k <= 1:
                return 0
    
            count = 0
            currProduct = 1
            left = 0
            for right in range(len(nums)):
                currProduct *= nums[right]
                
                while currProduct >= k:
                    currProduct /= nums[left]
                    left += 1
    
                count += right - left + 1
    
            return count
      ```
    </details>
1. [643. Maximum Average Subarray I]([https://leetcode.com/problems/subarray-product-less-than-k](https://leetcode.com/problems/maximum-average-subarray-i)  
   Note that the Sliding window approach is only valid because numbers are positive.
   Once find a valid window, increase the count by right - left + 1  
    <details>

      ```python
        def findMaxAverage(self, nums: List[int], k: int) -> float:
            maxSum = 0
            for i in range(k):
                maxSum += nums[i]
            currSum = maxSum
    
            for right in range(k, len(nums)):
                currSum += nums[right] - nums[right - k]
                maxSum = max(maxSum, currSum)
            
            return maxSum / k
      ```
    </details>    
