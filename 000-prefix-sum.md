# Prefix Sum
1. [560. Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k)  
Key observation is a subarray of index i to j (exclusive) is the difference of subarray (0, i - 1) to (0, j). To find whether a subarray sum is k, we can find
whether there are two subarrays starting with first element, and their difference is k. If we save the prefix sum and its frequency into hash map, then to find whether prefixSum  
exist in hash map would be O(1). One edge case is 0 need to be added to the map as prefixSum. Brute force approach is also provided just in case. 
Also provide a approach to deal with two scenarios differently: 1. Subarray starts from first one 2. Subarrat starts from not the first one without adding 0 to hash map. The code is bit longer buch more clear
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

    # A longer but more clear way
        def subarraySum(self, nums: List[int], k: int) -> int:
           prefixSumFreq = Counter()
           currSum = 0
           result = 0
           for num in nums:
               currSum += num
               if currSum == k:
                   result += 1
               
               target = currSum - k
               result += prefixSumFreq[target]
               prefixSumFreq[currSum] += 1
   
           return result

      # Brute force
        def subarraySum(self, nums: List[int], k: int) -> int:
        result = 0
        for i in range(len(nums)):
            currSum = 0
            for j in range(i, len(nums)):
                currSum += nums[j]
                if currSum == k:
                    result += 1
        
        return result        
    ```
   </details>

1. [523. Continuous Subarray Sum](https://leetcode.com/problems/continuous-subarray-sum)
Save presum and its first index. If currSum % k == 0, and i + 1 >= minLen, meaning the subarray starts with first element has at least minLen elements, and the sum is multiple of k. Otherwise see if currSum exist in the hash map, if so, check its first index, and see if there are enough elements for the subarray, if so return True. 
   <details>

    ```python
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        preSumFirstIdxMap = {}
        currSum = 0
        minLen = 2
        for i, num in enumerate(nums):
            currSum += num
            currSum %= k
            if currSum == 0 and i + 1 >= minLen:
                return True
            
            if currSum in preSumFirstIdxMap:
                if i - preSumFirstIdxMap[currSum] >= minLen:
                    return True
            else:
                preSumFirstIdxMap[currSum] = i
        
        return False       
    ```
   </details>
