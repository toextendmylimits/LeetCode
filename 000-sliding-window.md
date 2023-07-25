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
