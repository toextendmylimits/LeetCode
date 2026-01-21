## 300. Longest Increasing Subsequence
I use dynamic programming where dp[i] is the length of the longest increasing subsequence ending at index i.  
For each position, I look at all earlier positions with smaller values and extend the best subsequence found so far.  
The answer is the maximum value in dp.  
This runs in O(n²) time and O(n) space.  

## 3. Longest Substring Without Repeating Characters
Use dp. initial value is 1  

## 827. Making A Large Island

## 23. Merge k Sorted Lists
Divide and conquer

## 198. House Robber

## 739. Daily Temperatures

## 5. Longest Palindromic Substring
I try every position as a palindrome center. 
For each center, I expand left and right while characters match, once for odd and once for even length. 
The helper returns the exact valid boundaries, and I keep the best window.

## 1462. Course Schedule IV
This is reachability in a DAG.   
I topologically sort the courses and propagate prerequisite relationships forward: if u → v, then all prerequisites of u are also prerequisites of v.   
I precompute a boolean matrix so each query is O(1).  

## 678. Valid Parenthesis String
I keep a range [low, high] representing the minimum and maximum possible number of unmatched left parentheses.  
'(' increases both, ')' decreases both, and '*' expands the range.  
If high ever drops below zero, it’s invalid.  
At the end, if low is zero, a valid interpretation exists.  

## 33. Search in Rotated Sorted Array
This is binary search on a rotated array.  
At each step, one half is guaranteed sorted.  
I detect the sorted half and check if the target lies inside it — if yes, I search there; otherwise, I discard it.  
That keeps the time complexity at O(log n).  

# TO MEMORIZE
## 300. Longest Increasing Subsequence
## 827. Making A Large Island
## 5. Longest Palindromic Substring
## 1462. Course Schedule IV
## 678. Valid Parenthesis String
## 33. Search in Rotated Sorted Array
