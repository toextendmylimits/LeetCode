# Two Pointers
1. [88. Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array)
1. [1213. Intersection of Three Sorted Arrays](https://leetcode.com/problems/intersection-of-three-sorted-arrays)  
Two slightly different approaches and the second one is easier to understand
   <details>

   ```python
    def arraysIntersection(self, arr1: List[int], arr2: List[int], arr3: List[int]) -> List[int]:
        result = []
        i = 0
        j = 0
        k = 0
        while i < len(arr1) and j < len(arr2) and k < len(arr3):
            if arr1[i] == arr2[j] == arr3[k]:
                result.append(arr1[i])
                i += 1
                j += 1
                k += 1
            elif arr1[i] < arr2[j]:
                i += 1
            elif arr2[j] < arr3[k]:
                j += 1
            else:
                k += 1
        
        return result

      # Easy to understand than previous branch
       def arraysIntersection(self, arr1: List[int], arr2: List[int], arr3: List[int]) -> List[int]:
        result = []
        i = 0
        j = 0
        k = 0
        while i < len(arr1) and j < len(arr2) and k < len(arr3):
            if arr1[i] == arr2[j] == arr3[k]:
                result.append(arr1[i])
                i += 1
                j += 1
                k += 1
            else:
                maxNum = max(arr1[i], arr2[j], arr3[k])
                if arr1[i] < maxNum:
                    i += 1
                if arr2[j] < maxNum:
                    j += 1
                if arr3[k] < maxNum:
                    k += 1
        
        return result
   ```
   </details>
1. [125. Valid Plalindrome](https://leetcode.com/problems/valid-palindrome)  
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
1. [680 Valid Palindrome II](https://leetcode.com/problems/valid-palindrome-ii)  
   If character at i isn't equal to j, then either i or jth character can be deleted, and then check whether the substring is palindrome
   <details>

      ```python
       def validPalindrome(self, s: str) -> bool:
           def isPalindrome(start, end):
               while start < end:
                   if s[start] != s[end]:
                       return False
                   start += 1
                   end -= 1
               return True
   
           start = 0
           end = len(s) - 1
           while start < end:
               if s[start] != s[end]:
                   return isPalindrome(start, end - 1) or isPalindrome(start + 1, end)
               else:
                   start += 1
                   end -= 1
           
           return True

      # Follow-up delete at most n characters
        def validPalindrome(self, s: str, n) -> bool:
           def checkPalindrome(start, end, mismatches):
               while start < end:
                   if s[start] != s[end]:
                       return mismatches > 0 and (checkPalindrome(start, end - 1, mismatches - 1) or checkPalindrome(start + 1, end, mismatches - 1))
                   else:
                       start += 1
                       end -= 1
               
               return True
           
           return checkPalindrome(0, len(s) - 1, n)       
      ```
   </details>

1. [2330. Valid Palindrome IV](https://leetcode.com/problems/valid-palindrome-iv)  
   Two pointers, check mismatches greater than 2  
   <details>

      ```python
       def makePalindrome(self, s: str) -> bool:
           mismatches = 0
           left = 0
           right = len(s) - 1
           while left < right:
               if s[left] != s[right]:
                   mismatches += 1
                   if mismatches > 2:
                       return False
               left += 1
               right -= 1
           
           return True     
      ```
   </details>
1. [26. Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)  
   One pointer point to unique number, and is initialized to 1. The other pointer point to elements of the array, starting from second element. If an element is not equal to its previous number, then advance the pointer fo unique number. In the end, return index of unique number  
   <details>

   ```python
    def removeDuplicates(self, nums: List[int]) -> int:
        uniqueNumIdx = 1
        for i in range(1, len(nums)):
            if nums[i] != nums[i - 1]:
                nums[uniqueNumIdx] = nums[i]
                uniqueNumIdx += 1
        
        return uniqueNumIdx
   ```
   </details>

1. [80. Remove Duplicates from Sorted Array II](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii)  
One pointer called resultIdx point to unique number, and is initialized to 1. The other pointer point to elements of the array, starting from second element. Have a variable of count. In each iteration, If an element is not equal to previous number, increase count otherwise reset count to 1. If the count is less than 2, then advance resultIdx.
   <details>

   ```python
    def removeDuplicates(self, nums: List[int]) -> int:
        resultIdx = 1
        count = 1
        for i in range(1, len(nums)):
            if nums[i] == nums[i - 1]:
                count += 1
            else:
                count = 1
            
            if count <= 2:
                nums[resultIdx] = nums[i]
                resultIdx += 1
        
        return resultIdx
   ```
   </details>

1. [189. Rotate Array](https://leetcode.com/problems/rotate-array)  
   A very inutitive approach is to create a new array, and let its (i + k) % len element equal to ith element of the original array  
   A better approach to to reverse arrays from 1 to len - 1, then from 0 to k -1, then from k to len - 1
   <details>

   ```python
    def rotate(self, nums, k):
        numsCount = len(nums)
        result = [0] * numsCount
        for i in range(numsCount):
            result[(i + k) % numsCount] = nums[i]

        for i in range(numsCount):
            nums[i]  = result[i]
   ```

   ```python
    def rotate(self, nums: List[int], k: int) -> None:
        def reverse(nums, start, end):
            left = start
            right = end
            while left < right:
                nums[left], nums[right] = nums[right], nums[left]
                left += 1
                right -= 1
        k %= len(nums)
        reverse(nums, 0, len(nums) - 1)
        reverse(nums, 0, k - 1)
        reverse(nums, k, len(nums) - 1)
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
1. [122. Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii)  
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
1. [3 Sum Closet](https://leetcode.com/problems/3sum-closest)  
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
   <details>
      
      ```python
       def sortColors(self, nums: List[int]) -> None:
           red = 0
           white = 0
           blue = len(nums) - 1
           while white <= blue:
               if nums[white] == 0:
                   nums[red], nums[white] = nums[white], nums[red]
                   red += 1
                   white += 1
               elif nums[white] == 1:
                   white += 1
               else:
                   nums[white], nums[blue] = nums[blue], nums[white]
                   blue -= 1
      ```
   </details>

1. [Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string)  
   Use built-in function
   ```
   return " ".join(reversed(s.split()))
   ```
   Rewrite the functions join, reversed(easy), and split
   <details>

      ```python
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
   </details>
   ```
1. [285. Move Zeroes](https://leetcode.com/problems/move-zeroes)  
   ***My own approach - Find first zero idx, and then liner scan the array starting from the element after zero. If zero, do othing. Otherwise swap zero with non-zero, and update idx for zero***  
   ***Approach 1 - Two steps, first move all nonzeros to the front, then fill the rest with zeros***

   ***Approach 2 - Scan array, if element is not zero, swap it with element at nonZeroIdx, and then increase nonZeroIdx***
   <details>

      ```python
          def moveZeroes(self, nums: List[int]) -> None:
        nonZeroIdx = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[nonZeroIdx], nums[i] = nums[i], nums[nonZeroIdx]
                nonZeroIdx += 1
        
      ```
   </details>
   
1. [67. Add Binary](https://leetcode.com/problems/add-binary)    
   Just add bit by bit, and in the end, if carry is 1, append 1       
   <details>
      
      ```python
       def addBinary(self, a: str, b: str) -> str:
           carry = 0
           result = deque()
           i = len(a) - 1
           j = len(b) - 1
           while i >= 0 or j >= 0:
               digit1 = int(a[i]) if i >= 0 else 0
               digit2 = int(b[j]) if j >= 0 else 0
   
               currSum = digit1 + digit2 + carry
               
               result.appendleft(currSum % 2)
               carry = currSum // 2
   
               i -= 1
               j -= 1
   
           if carry == 1:
               result.appendleft(1)
   
           return "".join([str(i) for i in result])
      ```
   </details>
## Medium
1. [11. Container With Most Water](https://leetcode.com/problems/container-with-most-water)    
   Intuition:
   Area between two positions equal to width * min(left height, right height) 

   Idea:
   1. The widest container (using first and last line) is a good candidate, because of its width. Its water level is the height of the smaller one of first and last line.  
   1. All other containers are less wide and thus would need a higher water level in order to hold more water.   
   1. The smaller one of first and last line doesn't support a higher water level and can thus be safely removed from further consideration.

   Algorithms:
   Have two pointers, one point to first index, and the other point to last index.  
   When left is less than right, have a loop:
   1. At each iteration, check whether the area between left and right is greater than result, if so, update
   1. If left height is less than right hight, then the only way to find potential larger area is to move left, as moving right will cause width to decrease but not causing height to increase
   1. Similaryly if left height is greater than or equal to height, move right pointer  
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
   
## Difficult
1. [42. Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water)  
   The basic intuition of the problem is as follows:  
   1. An element of the array can store water if there are higher bars on the left and the right.   
   1. The amount of water to be stored in every position can be found by finding the heights of bars on the left and right sides.   
   1. The total amount of water stored is the summation of the water stored in each position.  
     
   ***Approach 1 - brutal force***
   Time complexity O(N*2), space complexity O(1)
   The idea:  
   Traverse every array element and find the highest bars on the left and right sides. Take the smaller of two heights. The difference between the smaller          height and the height of the current element is the amount of water that can be stored in this array element.  

   Steps:
   1. Traverse the array from start to end:
      For every element: 
      1. Traverse the array from start to that index and find the maximum height on left (maxLeft) and 
      1. Traverse the array from the current index to the end, and find the maximum height on right (maxRight).
      1. The amount of water that will be stored in this column is min(maxLeft, maxRight) – array[i], add this value to the total amount of water stored
   1. In the end, returnt the total amount of water stored.
   <details>
      
      ```python
       def trap(self, height: List[int]) -> int:
           result = 0
           for i in range(len(height)):
               maxLeft = height[i]
               maxRight = height[i]
               for j in range(0, i):
                   maxLeft = max(maxLeft, height[j])
               
               for j in range(i + 1, len(height)):
                   maxRight = max(maxRight, height[j])
               
               result += min(maxLeft, maxRight) - height[i]
           
           return result
      ```
   </details>  

   ***Approach 2 - Prepopulate max left and max right for each element***
   Time complexity O(N*2), space complexity O(1)  

   The idea:  
   In previous approach, for every element we needed to calculate the highest element on the left and on the right. So, to reduce the time complexity:
   1. For every element we can precalculate and store the highest bar on the left and on the right (say stored in arrays left[] and right[]). 
   1. Then iterate the array and use the precalculated values to find the amount of water stored in this index, which is the same as ( min(left[i], right[i]) – arr[i] )

   Steps:
   Create two arrays left[] and right[] of size N. Create a variable (say max) to store the maximum found till a certain index during traversal.

   1. Run one loop from left to right and in each iteration update max and also assign left[i] = max.  
   1. Run another loop right end to left and in each iteration update max found till now and also assign right[i] = max.  
   1. Traverse the array from start to end.  
      1. The amount of water that will be stored in this column is min(left[i], right[i]) – array[i]  
      1. Add this value to the total amount of water stored  
   1. Print the total amount of water stored.  
   <details>
      
      ```python
       def trap(self, height: List[int]) -> int:
           result = 0
           for i in range(len(height)):
               maxLeft = height[i]
               maxRight = height[i]
               for j in range(0, i):
                   maxLeft = max(maxLeft, height[j])
               
               for j in range(i + 1, len(height)):
                   maxRight = max(maxRight, height[j])
               
               result += min(maxLeft, maxRight) - height[i]
           
           return result
      ```
   </details>  
   
   ***Approach 3***  
   Intution:  
   A poisiton can store water if there are higher bars on its left and right  
   The water to be stored in a position is the smallest value of max left bar height and max right bar height then substract its height  
   The total amount of water is the summontaion of the water stored in each position  
   
   Algorithm:
   1. Have two pointers, one point to left, and the other point to right, have variable maxLeft and maxRight for the max left bar height and max right bar height  
   1. Loop if left is less than right:  
      1. At each iteration, update maxLeft if the current height is greater than maxLeft, and update maxRight if current height is greater than maxRight
      1. If maxLeft is less than maxRight, then position at left can hold water maxLeft - current height, and add it total, and increase left
      1. Else if maxLeft is greater than maxRight, then position at right can hold water maxRight - current height, and add it total, and decrease right
   1. Return total amount of water
   
   <details>
      
      ```python
       def trap(self, height: List[int]) -> int:
           maxLeft = height[
           maxRight = 0
           left = 0
           right = len(height) - 1
           result = 0
           while left < right:
               maxLeft = max(maxLeft, height[left])
               maxRight = max(maxRight, height[right])
               if maxLeft < maxRight:
                   result += maxLeft - height[left]
                   left += 1
               else:
                   result += maxRight - height[right]
                   right -= 1
                   
           return result
      ```
   </details>
   
