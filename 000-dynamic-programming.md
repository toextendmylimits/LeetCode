# Dynamic programming
1.  [2713. Maximum Strictly Increasing Cells in a Matrix](https://leetcode.com/problems/maximum-strictly-increasing-cells-in-a-matrix)  
    A brute force way is probably find all the increasing sequence and return the longest one's length.  

    Very difficult. One key observation is probably it's good idea to start from the smallest numbers, given we are more likely to find a increasing sequence. For a given cell, the longest sequence reaching it depends on the longest sequence that can reach to elements which are smaller than it in the row, and the longest sequence that can reach to elements which are smaller than it in the column because we can expand the sequence by one.  

    So the idea is to use dynamic programming. Define dp[i][j] represent longest sequence that can reach position i, j, and have a hash map for num value and list of positions. Define an array for longest sequence in each row and column. Sort the hash map by number in ascending orders. From the smallest number, update dp[i][j] = max(max_seq_rows[i], max_seq_cols[j], then update the longest sequence in relevant row and column
    <details>
        
      ```python
        def maxIncreasingCells(self, mat: List[List[int]]) -> int:
            rows = len(mat)
            cols = len(mat[0])
            dp = [[0 for c in range(cols)] for r in range(rows)]
            num_positions_map = defaultdict(list)
            for r in range(rows):
                for c in range(cols):
                    num_positions_map[mat[r][c]].append((r, c))
            
            max_seq_rows = [0] * rows
            max_seq_cols = [0] * cols
            result = 0
            for num in sorted(num_positions_map.keys()):
                positions = num_positions_map[num]
                for r, c in positions:
                    dp[r][c] = max(max_seq_rows[r], max_seq_cols[c]) + 1
                
                for r, c in positions:
                    max_seq_rows[r] = max(max_seq_rows[r], dp[r][c])
                    max_seq_cols[c] = max(max_seq_cols[c], dp[r][c])
                    result = max(result, max_seq_rows[r], max_seq_cols[c])
            return result
      ```
    </details>  
1.  [70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs)  
    Let curr represent distinct ways to reach current step, prev1 represent distinct ways to reach to previous step, and prev2 represent distinct ways to reach to previous 2 steps, then
    curr = prev1 + prev2 as from previous step, user can jump one step and reach current step, and from previous 2 step, user can jump two steps and reach current step
    <details>
        
      ```python
        def climbStairs(self, n: int) -> int:
            if n == 1:
                return 1
    
            if n == 2:
                return 2
    
            twoStepBefore = self.climbStairs(1) # steps to reach previous two steps
            oneStepBefore = self.climbStairs(2) # steps to reach previous one steps
            for i in range(3, n + 1):
                total = oneStepBefore + twoStepBefore
                twoStepBefore = oneStepBefore
                oneStepBefore = total
            
            return oneStepBefore
      ```
    </details>

1.  [198. House Robber](https://leetcode.com/problems/house-robber)    
   Use moneyOfRobbingPrev1 to represent the money it gets to rob the previous house(meaning current house cann't be robbed agin), and moneyOfRobbingPrev2 to represent the money it gets to rob the previous2 house, so the current house can be robbed again.  
    <details>
        
      ```python
        def rob(self, nums: List[int]) -> int:
            moneyOfRobbingPrev1 = 0
            moneyOfRobbingPrev2 = 0
            for i in range(len(nums)):
                temp = moneyOfRobbingPrev1
                moneyOfRobbingPrev1 = max(moneyOfRobbingPrev1, moneyOfRobbingPrev2 + nums[i])
                moneyOfRobbingPrev2 = temp
            
            return moneyOfRobbingPrev1

      ```
    </details>
1. [213. House Robber II](https://leetcode.com/problems/house-robber-ii)
1. [337. House Robber III](https://leetcode.com/problems/house-robber-iii/)|
1. [5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring)  
   The problem can be broken down into subproblems which are reused several times. Overlapping subproblems lead us to Dynamic Programming.  
   We decompose the problem as follows:  
   1. State variable  
    The start index and end index of a substring can identify a state, which influences our decision.  
    So the state variable is state(start, end) indicates whether s[start, end] inclusive is palindromic  

   1. Goal state  
    max(end - start + 1) for all state(start, end) = true  

   1. State transition  
      if character at start is same as it at end, then if end - start == 1, or substring from start + 1 to end - 1 is palindrome, the the string from start to end is palindrome 

1. [647. Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings)    
   Approach 1 DP, Approach 2 extend from center
    <details>
        
      ```python
        def countSubstrings(self, s: str) -> int:
            size = len(s)
            isPalindrome = [[False] * size for _ in range(size)]
            
            count = 0
            for start in range(size - 1, -1, -1):
                for end in range(start, size, 1):
                    if s[start] == s[end]:
                        if end - start <= 2 or isPalindrome[start + 1][end - 1]:
                            isPalindrome[start][end] = True
    
                    if isPalindrome[start][end]:
                        count += 1
            
            return count

    def countSubstrings(self, s: str) -> int:
        def extendPalindrome(s, left, right):
            count = 0
            while left >= 0 and right < len(s) and s[left] == s[right]:
                count += 1
                left -= 1
                right += 1
                
            return count
        
        count = 0
        for i in range(len(s)):
            count += extendPalindrome(s, i, i)
            count += extendPalindrome(s, i, i + 1)
        
        return count      
      ```
    </details>

1. [516. Longest Palindromic Subsequence](https://leetcode.com/problems/longest-palindromic-subsequence)  
    <details>
        
      ```python
        def longestPalindromeSubseq(self, s: str) -> int:
            dp = [[0] * len(s) for _ in range(len(s))]
            for start in range(len(s) - 1, -1, -1):
                dp[start][start] = 1
    
                for end in range(start + 1, len(s)):
                    if s[start] == s[end]:
                        dp[start][end] = dp[start + 1][end - 1] + 2
                    else:
                        dp[start][end] = max(dp[start + 1][end], dp[start][end - 1])
            return dp[0][len(s) - 1]     
      ```
    </details>
1. [1216. Valid Palindrome III](https://leetcode.com/problems/valid-palindrome-iii)    
    <details>
        
      ```python
        def isValidPalindrome(self, s: str, k: int) -> bool:
            dp = [[0] * len(s) for _ in range(len(s))] 
            for start in range(len(s) - 1, -1, -1):
                dp[start][start] = 1
    
                for end in range(start + 1, len(s)):
                    if s[start] == s[end]:
                        dp[start][end] = dp[start + 1][end - 1] + 2
                    else:
                        dp[start][end] = max(dp[start][end - 1], dp[start + 1][end])
                        
            return dp[0][len(s) - 1] + k >= len(s)  
      ```
    </details>    
1.  [62. Unique Paths](https://leetcode.com/problems/unique-paths)  
   Since the robot can only move right and down, when it arrives at a point, it either arrives from left or above. If we use dp[i][j] for the number of unique paths to arrive at the point (i, j), then the state equation is dp[i][j] = dp[i][j - 1] + dp[i - 1][j]. Moreover, we have the base cases dp[0][j] = dp[i][0] = 1 for all valid i and j.  
    <details>
        
      ```python
        def uniquePaths(self, m: int, n: int) -> int:
            dp = [ [0] * n for _ in range(m)]
            for c in range(n):
                dp[0][c] = 1
            
            for r in range(m):
                dp[r][0] = 1
            
            for r in range(1, m):
                for c in range(1, n):
                    dp[r][c] = dp[r - 1][c] + dp[r][c - 1]
            
            return dp[m - 1][n - 1]
      ```
    </details>

1.  [322. Coin Change](https://leetcode.com/problems/coin-change)   
   dp[i] represent the minimum number of coins to make up amount i  
    For each coin, dp[i] = min(dp[i], dp[i - coin] + 1)  
    TC = O(amount * number of coins), SP = O(amount)  
    <details>
        
      ```python
        def coinChange(self, coins: List[int], amount: int) -> int:
            dp = [float("inf")] * (amount + 1)
            dp[0] = 0
            for coin in coins:
                for x in range(coin, amount + 1):
                  if x >= coin:
                    dp[x] = min(dp[x], dp[x - coin] + 1)
            
            return -1 if dp[amount] == float("inf") else dp[amount]
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
