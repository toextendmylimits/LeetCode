class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        result = []
        start = 0
        end = 0
        while end < len(nums):
            if end + 1 < len(nums) and nums[end + 1] == nums[end] + 1:
                end += 1
            else:
                result.append(self.formatRange(nums[start], nums[end]))
                start = end + 1
                end = start
        return result
    
    def formatRange(self, start, end):
        if start == end:
            return str(start)
        
        return str(start) + "->" +str(end)
