class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        majority = None
        count = 0
        for n in nums:
            if count == 0:
                majority = n
            count += 1 if majority == n else -1
        
        return majority

            
