15-seconds:
I scan the array and keep current_sum, the best subarray ending at this position. 
At each element, I choose to start fresh or extend the previous sum, 
and track max_sum as the global best. This is Kadane’s Algorithm — O(n) time, O(1) space.”

30 seconds:
To find the maximum subarray sum, I use Kadane’s Algorithm. 
I maintain current_sum, which is the best sum of a subarray ending at the current index. 
For each number, I decide whether to start a new subarray at that number or extend the previous one: 
current_sum = max(x, current_sum + x). I also maintain max_sum, the best sum seen so far.
By updating both in a single pass, I get an O(n) time, O(1) space solution.

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        current_sum = nums[0]
        max_sum = nums[0]

        for x in nums[1:]:
            # Either extend the previous subarray or start a new one
            current_sum = max(x, current_sum + x)
            max_sum = max(max_sum, current_sum)

            return max_sum
