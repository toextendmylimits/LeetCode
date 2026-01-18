## 3. Longest Substring Without Repeating Characters
I use a sliding window with the invariant that all characters inside the window are unique.  
I scan the string once, expanding the window when the invariant holds and moving the left boundary just enough to restore it when a duplicate appears.  
Because both pointers only move forward, the algorithm runs in linear time while tracking the maximum window size.  

## 76. Minimum Window Substring
I use a sliding window.  
I expand the right pointer to satisfy all required character counts, track how many characters meet their required frequency, then shrink from the left to minimize the window.  
Each character is processed at most twice, so it’s O(n) time.  

## 560. Subarray Sum Equals K
I use a running prefix sum and a hashmap that counts how often each prefix sum has appeared.  
For each position, if the current prefix sum is S, any earlier prefix sum S − k means the subarray between them sums to k.  
I accumulate how many times S − k has appeared so far, then record the current prefix sum.  
This runs in O(n) time and O(n) space.  

## 1004. Max Consecutive Ones III
Use a sliding window. Count zeros in the window as flips used.   
Expand right; if zeros exceed k, move left until zeros ≤ k again.   
Track the max window length. Two pointers → O(n).  

## 20. Valid Parentheses
Easy.

## 739. Daily Temperatures
I use a monotonic decreasing stack of indices.  
Each index represents a day waiting for a warmer temperature.  
When I see a warmer day, I pop all colder days from the stack and compute the distance.  
Each index is pushed and popped once, so the solution runs in O(n) time.  

## 34. Find First and Last Position of Element in Sorted Array
Easy. Binary Search.

## 215. Kth Largest Element in an Array
Use heap.

## 200. Number of Islands

## 236. Lowest Common Ancestor of a Binary Tree
Post-order DFS. Each call returns either p, q, or the LCA.  
If both left and right return non-null, the current node is the LCA; otherwise, return the non-null result upward.    

## 1644. Lowest Common Ancestor of a Binary Tree II
## 235. Lowest Common Ancestor of a Binary Search Tree

## 104. Maximum Depth of Binary Tree
This is a DFS recursion.  
If the node is null, depth is zero.  
Otherwise, the depth is one plus the maximum depth of its left and right subtrees.  
We visit each node once, so time is O(n), space is proportional to tree height.  

## 101. Symmetric Tree
I compare the left and right subtrees as mirror pairs.   
For each pair, values must match and left’s left mirrors right’s right, and vice versa.   
If all pairs satisfy this, the tree is symmetric.  

## 146. LRU Cache
Had a look

## 380. Insert Delete GetRandom O(1)
I keep values in an array for O(1) random access, and a hashmap from value to its array index.   
Insert appends.   
Remove swaps the element with the array’s last element, updates the moved element’s index, then pops.   
getRandom picks uniformly from the array.  

## 339. Nested List Weight Sum
I traverse the nested list while tracking depth.   
When I encounter an integer, I add value × depth.   
I can do this with DFS by passing depth recursively, or BFS by processing level by level.  

## 364. Nested List Weight Sum II
**Two DFS passes: I use two DFS passes.**    
First, I compute the maximum nesting depth of the list.  
Then I do another DFS, passing the current depth.  
When I see an integer, I apply the inverse weight maxDepth − depth + 1 and add it to the sum.  
Lists recurse deeper with depth + 1.  
This guarantees deeper numbers get smaller weights  

**BFS: I use BFS level by level.**
I keep a running sum of all integers seen so far.
After each level, I add that sum into the result.
Shallow numbers stay in the running sum longer, so they’re added more times and get higher inverse weights

**DFS one pass There is also a one-pass version using algebra:**
during DFS I track total sum, depth-weighted sum, and max depth,
then apply a formula to compute the inverse-weighted result

## 252. Meeting Rooms
I sort all meetings by start time.   
Then I scan once and check whether any meeting starts before the previous one ends.   
If it does, there’s an overlap and I return false; otherwise true.  

## 253. Meeting Rooms II
**sweep line**
I use a sweep-line approach: add +1 at each meeting start and −1 at each end,   
sort all timestamps, and track the running number of active meetings.   
The maximum overlap is the number of rooms needed.  

**heap**
I sort the meetings by start time and use a min-heap to store end times of rooms in use.   
For each meeting, if the earliest ending meeting finishes by the current start time, I reuse that room by popping it from the heap.   
Then I push the current meeting’s end time.   
Because I pop at most one and always push one, the heap size never decreases, so the final heap size represents the maximum number of rooms needed.    

## 205. Isomorphic Strings
I scan both strings in parallel and track the first index where each character appears.    
For isomorphic strings, corresponding characters must have the same first-occurrence index.    
If at any position those indices differ, I return false; otherwise the patterns match.    

Use first_occurence_s1 for name, and use get to reduce branches  

## 394. Decode String
Just memorize the code for now.  
I parse the string left to right. Numbers build a repeat count, letters append to the current string. 
When I see left bracket, I push the current string and count onto a stack. 
When I see right bracket, I pop and repeat the decoded substring, then merge it back. This naturally handles nesting

# TO MEMORIZE
## 394. Decode String

# TO DO LATER
## 636. Exclusive Time of Functions
