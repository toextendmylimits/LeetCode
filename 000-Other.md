# These don't fall into any category
1. [169. Majority Element](https://leetcode.com/problems/majority-element)  
1. [53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray)  
    <details>
      
    ```python
    def maxSubArray(self, nums: List[int]) -> int:
        currSum = nums[0] # represent the largest sum of subarray ending index i
        result = currSum

        for i in range(1, len(nums)):
            currSum = max(nums[i], currSum + nums[i])
            result = max(currSum, result)
        
        return result
      
    ```
    </details>
