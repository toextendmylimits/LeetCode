# Slidng window
1. [1004. Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/)   
    Maintian a window that has at most k zeros.  
    <details>

      ```python
    def longestOnes(self, nums: List[int], k: int) -> int:
        maxLen = 0
        left = 0
        zeroCount = 0
        for right in range(len(nums)):
            if nums[right] == 0:
                zeroCount += 1
            
            while zeroCount > k:
                if nums[left] == 0:
                    zeroCount -= 1
                left += 1
            
            maxLen = max(maxLen, right - left + 1)
        return maxLen

      ```
    </details>
1. [485. Max Consecutive Ones](https://leetcode.com/problems/max-consecutive-ones)  
    Use max_len to record the result, curr_len to record the current string length with consective ones. Linear scan the list, in each  iteration, if number is one, increase curr_len and update max_len, else reset curr_len to 0.  
    <details>

      ```python
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        max_len = 0
        curr_len = 0
        for n in nums:
            if n == 1:
                curr_len += 1
                max_len = max(max_len, curr_len)
            else:
                curr_len = 0
                
        return max_len
      ```
    </details> 
1. [487. Max Consecutive Ones II](https://leetcode.com/problems/max-consecutive-ones-ii)
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
   Once find a valid window, increase the count by right - left + 1 which represent athe number of subarrays ending at index right, and starting at index greater or equal to left    
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

1. [76. Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring)  
    1. Have two hash maps, one for the original t, the other for sliding window
    2. For a character, if it is in the original t, and its frequency is the same, then find a match
    3. If the number of matches equal to the size of the orignal hash map, then move left pointer, decrease its freqency, and if its freqency is less than the original frequency, decrease the match

    <details>

      ```python
    def minWindow(self, s: str, t: str) -> str:
        if len(s) < len(t):
            return ""
        min_len = len(s) + 1
        counter_t = Counter(t)
        curr_counter = Counter()
        matches = 0
        left = 0
        result_start = -1
        for right in range(len(s)):
            if s[right] in counter_t:
                curr_counter[s[right]] += 1
                if curr_counter[s[right]] == counter_t[s[right]]:
                    matches += 1
            
            while matches == len(counter_t):
                curr_len = right - left + 1
                if curr_len < min_len:
                    min_len = curr_len
                    result_start = left
                    
                if s[left] in counter_t:
                    if curr_counter[s[left]] == counter_t[s[left]]:
                        matches -= 1
                    curr_counter[s[left]] -= 1
                left += 1

        return "" if result_start == -1 else s[result_start : result_start + min_len]
      ```
    </details>
1. [438. Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string)  
    1. Have two hash maps, one for the original t, the other for sliding window
    2. For a character, if it is in the original t, and its frequency is the same, then find a match
    3. If the number of matches equal to the size of the orignal hash map, add left to result if right - left + 1 = len(p), then move left pointer, decrease its freqency, and if its freqency is less than the original frequency, decrease the match

    <details>

      ```python
        def findAnagrams(self, s: str, p: str) -> List[int]:
            if len(s) < len(p):
                return []
            
            result = []
            origCounter = Counter(p)
            currCounter = Counter()
            match = 0
            left = 0
            for right in range(len(s)):
                rightChar = s[right]
                if rightChar in origCounter:
                    currCounter[rightChar] += 1
                    if currCounter[rightChar] == origCounter[rightChar]:
                        match += 1
                
                while match == len(origCounter):
                    if right - left + 1 == len(p):
                        result.append(left)
    
                    leftChar = s[left]
                    left += 1
                    if leftChar in origCounter:
                        currCounter[leftChar] -= 1
                        if currCounter[leftChar] < origCounter[leftChar]:
                            match -= 1
            return result
      ```
    </details>

1. [424. Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement)  
    The intuition is we should keep a chracter that appears more often, and replace the less frequent characters. So in a window of substring (left, right), the replace cost is: right - left + 1 - max freqency.

    <details>

      ```python
        def findAnagrams(self, s: str, p: str) -> List[int]:
            if len(s) < len(p):
                return []
            
            result = []
            origCounter = Counter(p)
            currCounter = Counter()
            match = 0
            left = 0
            for right in range(len(s)):
                rightChar = s[right]
                if rightChar in origCounter:
                    currCounter[rightChar] += 1
                    if currCounter[rightChar] == origCounter[rightChar]:
                        match += 1
                
                while match == len(origCounter):
                    if right - left + 1 == len(p):
                        result.append(left)
    
                    leftChar = s[left]
                    left += 1
                    if leftChar in origCounter:
                        currCounter[leftChar] -= 1
                        if currCounter[leftChar] < origCounter[leftChar]:
                            match -= 1
            return result](https://leetcode.com/problems/longest-repeating-character-replacement)https://leetcode.com/problems/longest-repeating-character-replacement
      ```
    </details>
