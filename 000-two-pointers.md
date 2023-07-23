# Two Pointers
1. [Valid Plalindrome](https://leetcode.com/problems/valid-palindrome)
   Use isalnum to check whether a character is numerica or alphabetic
2. [3 sum](https://leetcode.com/problems/3sum)
   duplicate triplets are not allowed, so it's important to avoid reduction for the first element, and the two pointers for second and third elements
3. [3 Sum Smaller](https://leetcode.com/problems/3sum-smaller)  
   Increment the count more drastically:
   ```
    if total < target:
     count += right - left
     left += 1
   ```
   
