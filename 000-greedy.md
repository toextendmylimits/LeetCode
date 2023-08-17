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

1. [55. Jump Game](https://leetcode.com/problems/jump-game/)  
   Have a variable maxPos to record the furthest index that can be reached    
   Liner search the array, at each step, check whether it can be reached, if not return False, otherwise update the furthest index that can be reached, if the last index can be reached, return True  
   In the end, just return False
   <details>

     ```python
       def canJump(self, nums: List[int]) -> bool:
           maxPos = 0
           i = 0
           for i in range(len(nums)):
               if i > maxPos:
                   return False
               
               maxPos = max(maxPos, i + nums[i])
               if i >= len(nums) - 1:
                   return True
           
           return False
     ```
   </details>
