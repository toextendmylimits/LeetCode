# Slidng window
1. [159. Longest Substring with At Most Two Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters)  
    <details>

      ```python
        def lengthOfLongestSubstringTwoDistinct(self, s: str) -> int:
            counter = Counter()
            maxLen = 0
            left = 0
            for right in range(len(s)):
                counter[s[right]] += 1
                while len(counter) > 2:
                    counter[s[left]] -= 1
                    if counter[s[left]] == 0:
                        del counter[s[left]]
                    left += 1
                
                currLen = right - left + 1
                if currLen > maxLen:
                    maxLen = currLen
    
            return maxLen
      ```
    </details>
1. [340. Longest Substring with At Most K Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters)  
    <details>

      ```python
        def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
            counter = Counter()
            maxLen = 0
            left = 0
            for right in range(len(s)):
                counter[s[right]] += 1
                while len(counter) > k:
                    leftChar = s[left]
                    counter[leftChar] -= 1
                    if counter[leftChar] == 0:
                        del counter[leftChar]
                    left += 1
    
                maxLen = max(maxLen, right - left + 1)
            return maxLen
      ```
    </details>
1. [643. Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i)  
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
1. [209. Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum)  
    Beware to return 0 if there is no such sub array
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
    ***Beware edge case that if k is less than or equal to 1, return 0 immediately***
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
 1. [3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters)
    <details>

      ```python
    def lengthOfLongestSubstring(self, s: str) -> int:
        freq = Counter()
        maxLen = 0
        left = 0
        for right in range(len(s)):
            freq[s[right]] += 1
            while freq[s[right]] > 1:
                freq[s[left]] -= 1
                left += 1

            maxLen = max(maxLen, right - left + 1)

        return maxLen
      ```
    </details>
1. [904. Fruit Into Baskets](https://leetcode.com/problems/fruit-into-baskets)  
    Find out the longest length of subarrays with at most 2 different numbers
    <details>

      ```python
        def totalFruit(self, fruits: List[int]) -> int:
            counter = Counter()
            left = 0
            maxPicked = 0
            for right in range(len(fruits)):
                counter[fruits[right]] += 1
    
                while len(counter) > 2:
                    leftFruit = fruits[left]
                    counter[leftFruit] -= 1
                    if counter[leftFruit] == 0:
                        del counter[leftFruit]
    
                    left += 1
    
                maxPicked = max(maxPicked, right - left + 1)
    
            return maxPicked
      ```
    </details>

## Difficult
1. [992. Subarrays with K Different Integers](https://leetcode.com/problems/subarrays-with-k-different-integers)  
    This problem will be a very typical sliding window, if it asks the number of subarrays with at most K distinct elements.
    Just need one more step to reach the folloing equation: exactly(K) = atMost(K) - atMost(K-1)
    <details>

      ```python
        def getCountOfAtMostKDistinct(self, nums, k):
            result = 0
            counter = Counter()
            left = 0
            for right in range(len(nums)):
                counter[nums[right]] += 1
    
                while len(counter) > k:
                    leftNum = nums[left]
                    counter[leftNum] -= 1
                    if counter[leftNum] == 0:
                        del counter[leftNum]
    
                    left += 1
                
                result += right - left + 1   
    
            return result   
        def subarraysWithKDistinct(self, nums: List[int], k: int) -> int:
            return self.getCountOfAtMostKDistinct(nums, k) - self.getCountOfAtMostKDistinct(nums, k - 1)
      ```
    </details>
