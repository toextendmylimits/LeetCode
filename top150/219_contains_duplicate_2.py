class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        numLastIdxMap = {}

        for i, n in enumerate(nums):
            if n in numLastIdxMap and i - numLastIdxMap[n] <= k:
                return True
            
            numLastIdxMap[n] = i
        
        return False
