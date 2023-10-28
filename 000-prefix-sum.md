# Prefix Sum
1. [560. Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k)
Key observation is a subarray of index i to j (exclusive) is the difference of subarray (0, i - 1) to (0, j). To find whether a subarray sum is k, we can find
whether there are two subarrays starting with first element, and their difference is k. If we save the prefix sum and its frequency into hash map, then to find whether prefixSum  
exist in hash map
   would be O(1). One edge case is 0 need to be added to the map as prefixSum 
  <details>

    ```python
      def subarraySum(self, nums: List[int], k: int) -> int:
          sumFreqMap = Counter()
          currSum = 0
          result = 0
          sumFreqMap[0] = 1
          for num in nums:
              currSum += num
              result += sumFreqMap[currSum - k]
              sumFreqMap[currSum] += 1
  
          return result          
    ```
  </details>
