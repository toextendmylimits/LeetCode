I track the lowest price so far.
On each day, if selling today gives a positive profit compared to that minimum, I update the max profit.
If today's price is even lower, I update the minimum instead

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        min_price = float('inf')
        max_profit = 0

        for price in prices:
            if price < min_price:
                min_price = price
            else:
                max_profit = max(max_profit, price - min_price)

        return max_profit
