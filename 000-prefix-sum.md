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
Save presum and its first index. If currSum % k == 0, and i + 1 >= minLen, meaning the subarray starts with first element has at least minLen elements, and the sum is multiple of k. Otherwise see if currSum exist in the hash map, if so, check its first index, and see if there are enough elements for the subarray, if so return True. Refer link https://leetcode.com/problems/continuous-subarray-sum/solutions/1405425/a-java-implementation-of-prefix-sum-that-may-be-easier-to-understand/
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

1. [528. Random Pick with Weight](https://leetcode.com/problems/random-pick-with-weight) 
   say we have the numbers 1, 5, 2 easiest solution is to construct the following array  
   arr[] = {0,1,1,1,1,1,2,2}  
   then generate a random number between 0 and 7 and return the arr[rnd]. This is solution is not really good though due to the space requirements it has (imagine a number beeing 2billion).  

   The solution here is similar but instead we construct the following array (accumulated sum)  
{1, 6, 8} generate a number between 1-8 and say all numbers generated up to 1 is index 0. all numbers generated greater than 1 and up to 6 are index 1 and all numbers greater than 6 and up to 8 are index 2. After we generate a random number to find which index to return we use binary search.  
   <details>

    ```python
      class Solution:
      
          def __init__(self, w: List[int]):
              self.prefixSums = []
              currSum = 0
              for weight in w:
                  currSum += weight
                  self.prefixSums.append(currSum)
      
          def pickIndex(self) -> int:
              randNum = random.randrange(1, self.prefixSums[-1] + 1) 
              for i, preSum in enumerate(self.prefixSums):
                  if randNum <= preSum:
                      return i

    # Binary search
        def pickIndex(self) -> int:
           randNum = random.randrange(1, self.prefixSums[-1] + 1) 
           left = 0
           right = len(self.prefixSums) - 1
           result = -1
           while left <= right:
               mid = left + (right - left) // 2
               if randNum <= self.prefixSums[mid]:
                   result = mid
                   right = mid - 1
               else:
                   left = mid + 1
           
           return result  
    ```
   </details>
