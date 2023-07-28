# Two Pointers
1. [Valid Plalindrome](https://leetcode.com/problems/valid-palindrome)  
   Use isalnum to check whether a character is numerica or alphabetic  
   <details>

   ```python
    def isPalindrome(self, s: str) -> bool:
        left = 0
        right = len(s) - 1
        while left < right:
            while left < right and not s[left].isalnum():
                left += 1

            while left < right and not s[right].isalnum():
                right -= 1

            if s[left].upper() == s[right].upper():
                left += 1
                right -= 1
            else:
                return False

        return True
   ```
   </details>
1. [121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock)  
   ***Importantly we are only allowed to buy and sell once, i.e. not trading multiple times.***     
   So idea is to buy low and sell high. Keep the low price and max profit. If a price is lower than current low price, update low price; otherwise, there could be profit, if that profit    is greater than current max profit, update current max profit
   <details>

   ```python
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
1. [122. Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-i)  
   ***Importantly we are only allowed to buy and sell at same day, and trade multiple times***       
   So idea is to build profit incrementally, on any day, if price is greather than previous day, then buy at previous day and sell on that day, and accumulate the profit
   <details>

   ```python
    def maxProfit(self, prices: List[int]) -> int:
        result = 0
        for i in range(1, len(prices)):
            potentialProfit = prices[i] - prices[i - 1]
            if potentialProfit > 0:
                result += potentialProfit

        return result
   ```
   </details>
1. [2 Sum less than k](https://leetcode.com/problems/two-sum-less-than-k)  
   Compare the valid two sum with existing one:
   ```
   if total < k:
      result = max(result, total)
   ```
1. [Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted)  
1. [3 sum](https://leetcode.com/problems/3sum)  
   duplicate triplets are not allowed, so it's important to avoid reduction for the first element, and the two pointers for second and third elements
1. [3 Sum Smaller](https://leetcode.com/problems/3sum-smaller)  
   Increment the count more drastically:
   ```
    if total < target:
     count += right - left
     left += 1
   ```
1. [3 Sum Closet](https://leetcode.com/problems/3sum-closes)  
   keep the minimum difference of two sum to target
   ```
    currDiff = total - target
    if abs(currDiff) < abs(minDiff):
        minDiff = currDiff

    if total < target:
        left += 1
    else:
        right -= 1
   ```
1. [Sort Colors](https://leetcode.com/problems/sort-colors)  
   3 pointers, left and mid both increase by 1 if mid value is 0, right decrease by 1 if mid value is 2
   ```
      if nums[white] == 0:
       if nums[red] != 0:
           nums[white], nums[red] = nums[red], nums[white]
       white += 1
       red += 1
   elif nums[white] == 1:
       white += 1
   else:
       if nums[blue] != 2:
           nums[white], nums[blue] = nums[blue], nums[white]

       blue -= 1
   ```
1. [Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string)  
   Use built-in function
   ```
   return " ".join(reversed(s.split()))
   ```
   Rewrite the functions join, reversed(easy), and split
   ```
    def join(self, words):
     result = ""
     for i, word in enumerate(words):
         result += (" " if i > 0 else "") + word
     return result

        
    def split(self, s):
        words = []
        currWord = ""
        for c in s:
            if c != " ":
                currWord += c
            elif currWord:
                words.append(currWord)
                currWord = ""
        
        if currWord:
            words.append(currWord)

        return words
   ```
1. [Valid Palindrome II](https://leetcode.com/problems/valid-palindrome-ii)   
   If char at left not equal right, check after removing either char, whether the remaining string is palindrome
1. [Move Zeroes](https://leetcode.com/problems/move-zeroes)  
   Two steps, first move all nonzeros to the front, then fill the rest with zeros
   
