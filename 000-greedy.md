# Greedy
1. [121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock)  
   Pick first price as the lowest price, and whenever price is lower than current lowest price, update lowest price; otherwise check whether the potential profit is larger than current profit
   <details>

     ```python
      def maxProfit(self, prices: List[int]) -> int:
          result = 0
          lowPrice = prices[0]
          for i in range(1, len(prices)):
              if prices[i] < lowPrice:
                  lowPrice = prices[i]
              else:
                  result = max(result, prices[i] - lowPrice)
          
          return result
     ```
   </details>

1. [53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray)  
   currSum represent the maximum sum of a subarray ending at an index i  
   bestSum represent the maximum sum of any subarray  
   <details>

     ```python
       def maxSubArray(self, nums: List[int]) -> int:
           currSum = nums[0]  # represent the max sum for a subarray ending at index i  
           bestSum = currSum
           for i in range(1, len(nums)):
               currSum = max(currSum + nums[i], nums[i])   
               bestSum = max(bestSum, currSum)
           
           return bestSum 
     ```
   </details>
