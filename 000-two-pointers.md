# Two Pointers
1. [Valid Plalindrome](https://leetcode.com/problems/valid-palindrome)
   Use isalnum to check whether a character is numerica or alphabetic
2. [2 Sum less than k](https://leetcode.com/problems/two-sum-less-than-k)  
   Compare the valid two sum with existing one:
   ```
   if total < k:
      result = max(result, total)
   ```
3. [Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted)  
4. [3 sum](https://leetcode.com/problems/3sum)  
   duplicate triplets are not allowed, so it's important to avoid reduction for the first element, and the two pointers for second and third elements
5. [3 Sum Smaller](https://leetcode.com/problems/3sum-smaller)  
   Increment the count more drastically:
   ```
    if total < target:
     count += right - left
     left += 1
   ```
   
