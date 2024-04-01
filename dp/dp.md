1. [91. Decode Ways](https://leetcode.com/problems/decode-ways)
   1. Simple backtrack
   2. Backtrack with memorization
   3. DP
   4. DP with constant space  
   Importantly to initialize dp array of length s.length() + 1, and dp[0] = 1  
   Also beware how to not constant space instead of dp array   
1. [96. Unique Binary Search Trees](https://leetcode.com/problems/unique-binary-search-trees)  
   The key observation is dp[i] += dp[j-1]* dp[i-j];
1. [198. House Robber](https://leetcode.com/problems/house-robber)  
   Master basic DP first and then can just use two variables intead of DP array.  
1. [279. Perfect Squares](https://leetcode.com/problems/perfect-squares)
