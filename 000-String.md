# String
1. [387. First Unique Character in a String](https://leetcode.com/problems/first-unique-character-in-a-string)    
    Use hash map to store each charcter, and how many times it appear in the string  
    Loop through the string, and if any character appear only once, return its index  
    In the end, return -1
    <details>

      ```python
        def firstUniqChar(self, s: str) -> int:
            counter = Counter(s)
            for i, ch in enumerate(s):
                if counter[ch] == 1:
                    return i
            
            return -1
      ```
    </details>   
        
1. [14. Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix)  
    The prefix must shorter than the first word.   
    1. Scan the first word, and for each character, check whether it exists in all the remaining words
    1. Scan the words, if the charcter doesn't exist in a word, then the prefix is found, return it, otherwise continue
    1. In the end, all characters of first word must exist in the remaining words, so just return the first word   
        <details>
            
            ```python
                def longestCommonPrefix(self, strs: List[str]) -> str:
                    if not strs:
                        return ""
                        
                    result = []
                    firstStr = strs[0]
                    for i in range(len(firstStr)):
                        for j in range(1, len(strs)):
                            if i >= len(strs[j]) or strs[j][i] != firstStr[i]:
                                return firstStr[:i]
                        
                    return firstStr
            ```
        </details>

1. [28. Find the Index of the First Occurrence in a String](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string)  
    A very intuitive approach is to traverse each possible substring of same length as needle in the haystack, and check if it equals to needle.
    1. Declare i represent index of needle, and j represent index of haystack, 
    1. Iterate i from 0 to len(haystack) - len(needle), in each interation
    1. Iterate j from 0 to len(needle) - 1, 
    1. In each iteration, check whether needle[j] == haystack[i + j] 
    1. If not equal, break out of the loop for iteration j
    1. If equal, check whether j equal to len(needle) - 1, if so the needle has been found, return i
    1. Return -1 in the end
    <details>

      ```python
        def strStr(self, haystack: str, needle: str) -> int:
            for i in range(len(haystack) - len(needle) + 1):
               for j in range(len(needle)):
                    if haystack[i + j] != needle[j]:
                       break
                    
                    if j == len(needle) - 1:
                        return i
            return -1     
      ```
    </details>
1. [8. String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi)  
    <details>

      ```python
          def myAtoi(self, s: str) -> int:
              result = 0
              i = 0
              while i < len(s) and s[i] == " ":
                  i += 1
              
              sign = 1
              if i < len(s):
                  if s[i] == "-":
                      sign = -1
                      i += 1
                  elif s[i] == "+":
                      i += 1
              limit = 2 ** 31
              while i < len(s) and s[i].isnumeric():
                  result = result * 10 + (ord(s[i]) - ord("0"))
                  if result >= limit:
                      return limit - 1 if sign > 0 else -limit
                  i += 1
              
              return result * sign           
      ```
    </details>
1. [38. Count and Say](https://leetcode.com/problems/count-and-say)  
    <details>

      ```python
        def countAndSay(self, n: int) -> str:
            def count(s):
                count = 1
                currChar = s[0]
                result = []
                for i in range(1, len(s)):
                    ch = s[i]
                    if ch == currChar:
                        count += 1
                    else:
                        result.append(str(count) + currChar)
                        currChar = ch
                        count = 1
                result.append(str(count) + currChar)        
                return "".join(result)
                    
            result = "1"
            for i in range(2, n + 1):
                result = count(result)
            
            return result
         
      ```
    </details>
