# Dynamic programming
1.  [70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs)  
    Let curr represent distinct ways to reach current step, prev1 represent distinct ways to reach to previous step, and prev2 represent distinct ways to reach to previous 2 steps, then
    curr = prev1 + prev2 as from previous step, user can jump one step and reach current step, and from previous 2 step, user can jump two steps and reach current step
    <details>
      ```python
      def climbStairs(self, n: int) -> int:
          if n < 2:
              return 1
          prev1 = 1 # distinct ways to reach current step from previous step by climbing 1 step
          prev2 = 1 # distinct ways to reach current setp from previous 2 step by climbing 2 steps
          for i in range(2, n + 1):
              total = prev1 + prev2
              prev2 = prev1
              prev1 = total
  
          return prev1
      ```
    </details>
    
# To revisit
1.  [5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring)  
    Time complexity O(N^2), space complexity O(N^2)
    <details>
        
      ```python
        def longestPalindrome(self, s: str) -> str:
            # dp[start][end] represent whether a substring from start to end(inclusive) is palindrome
            dp = [[False] * len(s) for _ in s]
            for start in range(len(s)):
                dp[start][start] = True
            result = s[0]
            minLen = 1
            for start in range(len(s) - 1, -1, -1):
                for end in range(start + 1, len(s)):
                    if s[start] == s[end]:
                        if end - start == 1 or dp[start + 1][end - 1]:
                            dp[start][end] = True
                            currLen = end - start + 1
                            if currLen > minLen:
                                minLen = currLen
                                result = s[start : end + 1]
            return result
      ```
    </details>
