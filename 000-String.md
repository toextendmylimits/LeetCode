# String
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
