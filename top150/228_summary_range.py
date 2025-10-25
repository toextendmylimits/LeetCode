class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        result = []
 
        i = 0
        while i < len(nums):
            start = nums[i]
            while i + 1 < len(nums) and nums[i + 1] == nums[i] + 1:
                i += 1
            
            result.append(self.formatRange(start, nums[i]))
            i += 1

        return result
    
    def formatRange(self, start, end):
        if start == end:
            return str(start)
        
        return str(start) + "->" +str(end)
