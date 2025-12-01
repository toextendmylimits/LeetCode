To reach step n, you either come from n−1 using one step, or from n−2 using two steps.
So the total ways to reach n equals ways(n−1) + ways(n−2).
I only keep the last two counts and iterate up to n, which gives O(n) time and O(1) space.

class Solution:
    def climbStairs(self, n: int) -> int:
        if n <= 2:
            return n
        
        one_step_before = 2  # ways to reach n-1
        two_steps_before = 1  # ways to reach n-2
        
        for _ in range(3, n + 1):
            current = one_step_before + two_steps_before
            two_steps_before = one_step_before
            one_step_before = current
        
        return one_step_before
