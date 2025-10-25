class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        seen = set(nums)
        maxLen = 0
        for i, n in enumerate(nums):
            if n - 1 in seen:
                continue
            
            currLen = 1
            while n + 1 in seen:
                currLen += 1
                n += 1
            maxLen = max(maxLen, currLen)
        
        return maxLen
