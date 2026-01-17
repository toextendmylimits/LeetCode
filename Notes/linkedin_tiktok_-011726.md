## 3. Longest Substring Without Repeating Characters
I use a sliding window with the invariant that all characters inside the window are unique.  
I scan the string once, expanding the window when the invariant holds and moving the left boundary just enough to restore it when a duplicate appears.  
Because both pointers only move forward, the algorithm runs in linear time while tracking the maximum window size.  

## 76. Minimum Window Substring
I use a sliding window.  
I expand the right pointer to satisfy all required character counts, track how many characters meet their required frequency, then shrink from the left to minimize the window.  
Each character is processed at most twice, so it’s O(n) time.  
