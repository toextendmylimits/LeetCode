# Greedy
1. [954. Array of Doubled Pairs](https://leetcode.com/problems/array-of-doubled-pairs/)
1. [2007. Find Original Array From Doubled Array](https://leetcode.com/problems/find-original-array-from-doubled-array) 
1. [1029. Two City Scheduling](https://leetcode.com/problems/two-city-scheduling)  
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
           maxReach = 0
           for i, n in enumerate(nums):
               if maxReach < i:
                   return False
               elif maxReach >= len(nums) - 1:
                   return True
   
               maxReach = max(maxReach, i + n)
              
           return False
     ```
   </details>

1. [45. Jump Game II](https://leetcode.com/problems/jump-game-ii)   
   Treated it as BFS. Have currMax represents the max point reachable in current level. At each level, increase steps, then tranverse all points at current level, update nextMax, and if nextMax is equal or greater than end position, then return steps. Then update currMax to be nextMax.
   <details>

     ```python
      def jump(self, nums: List[int]) -> int:
           if len(nums) <= 1:
               return 0
           
           currMax = 0
           steps = 0
           i = 0
           while i <= currMax:
               steps += 1
               nextMax = currMax
               while i <= currMax:
                   nextMax = max(nextMax, nums[i] + i)
                   i += 1
                   if nextMax >= len(nums) - 1:
                       return steps
               
               currMax = nextMax
           
           return -1
     ```
   </details>
1. [121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock)  
