
I compute the product of all elements except itself without division by using two passes.
First pass builds prefix products — product of everything to the left.
Second pass builds suffix products — product of everything to the right.
At each index, prefix × suffix gives the final answer.
Time is O(n), space O(1) excluding the output.

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [1] * n
        
        # prefix products
        prefix = 1
        for i in range(n):
            result[i] = prefix
            prefix *= nums[i]
        
        # suffix products
        suffix = 1
        for i in range(n - 1, -1, -1):
            result[i] *= suffix
            suffix *= nums[i]
        
        return result
