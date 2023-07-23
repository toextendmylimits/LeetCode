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
6. [3 Sum Closet](https://leetcode.com/problems/3sum-closes)  
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
7. [Sort Colors](https://leetcode.com/problems/sort-colors)  
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
8. [Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string)
   Use built-in function
   ```
   return " ".join(reversed(s.split()))
   ```
   Rewrite the functions join, reversed, and split
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
   
