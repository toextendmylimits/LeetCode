# String
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
