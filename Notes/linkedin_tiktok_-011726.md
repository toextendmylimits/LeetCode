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
