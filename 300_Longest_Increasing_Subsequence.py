I use dynamic programming where lis_lengths[i] represents the length of the longest increasing subsequence that ends at index i.
For each number, I look forward to all later numbers.
If a later number is larger, then it can extend the subsequence ending at the current index, so I update its DP value.
By the end, the maximum value in lis_lengths is the LIS length.
This runs in O(n²) time and is the standard DP solution for LIS.

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        lis_lengths = [1] * len(nums)
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[j] > nums[i]:
                    lis_lengths[j] = max(lis_lengths[j], lis_lengths[i] + 1)
        return max(lis_lengths)
            

