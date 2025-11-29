
This problem is about making the best choice at each house.
For every house, you decide between two options:

Rob this house → but then you must skip the previous one

Skip this house → and keep whatever the best total was so far

So for each house, you compare:

the best total if you don’t take it

the best total if you do take it, which includes the house’s money plus the best total from two houses back

By walking through the street once and always choosing the better of these two options, you get the maximum money without ever robbing two adjacent houses.

class Solution:
    def rob(self, nums: List[int]) -> int:
        rob_prev = 0      # max up to previous house
        rob_prev2 = 0     # max up to two houses ago

        for money in nums:
            rob_current = max(rob_prev, rob_prev2 + money)
            rob_prev2 = rob_prev
            rob_prev = rob_current

        return rob_prev
