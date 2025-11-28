We track both the max and min product ending at each position. For each new number, we consider three choices: 
the number itself, number × previous max, and number × previous min. 
We include the number alone because sometimes it's better to start a new subarray, 
especially after zeros or when previous products become worse than starting fresh. 
Then we pick the best and worst of the three, update global max, and move on. This handles negatives and zeros correctly in O(n).

class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        curr_max = curr_min = global_max = nums[0]

        for num in nums[1:]:
            # Store because we'll update curr_max, curr_min
            prev_max = curr_max
            prev_min = curr_min

            curr_max = max(num, num * prev_max, num * prev_min)
            curr_min = min(num, num * prev_max, num * prev_min)

            global_max = max(global_max, curr_max)

        return global_max
