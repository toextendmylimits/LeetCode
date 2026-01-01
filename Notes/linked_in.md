## 17. Letter Combinations of a Phone Number

Each digit maps to letters. I use backtracking: starting from the first digit,   
I try every mapped letter, append it to the current string, recurse to the next digit,   
and when I reach the end, I add the built string to the result.   
If the input is empty, I return an empty list.

# Trees

## 1644. Lowest Common Ancestor of a Binary Tree II
I do a bottom-up traversal like the normal LCA problem, returning a node when I find either target.  
At the same time, I track whether each target node is actually found in the tree.  
If both are found, I return the split point as the LCA; otherwise, I return null.  

Memorize the code.

## 235. Lowest Common Ancestor of a Binary Search Tree
**Recursive**:
This is a recursive DFS on a binary search tree.  
At each node, I compare its value with both target values.  
If both targets are smaller, I recurse into the left subtree.  
If both are larger, I recurse into the right subtree.  
Otherwise, the current node is where the paths split, so it’s the lowest common ancestor.  

**Iterative**:
Because this is a binary search tree, I can use its ordering.  
I start from the root and iterate downward.  
If both target nodes are smaller than the current node, I move left.  
If both are larger, I move right.  
The first node where they split—or match the current node—is the lowest common ancestor.  

## 339. Nested List Weight Sum
**Recursive DFS**:
I use DFS with a depth parameter. Starting at depth 1, I traverse the nested list.  
If an element is an integer, I add depth × value to the sum.  
If it’s a list, I recursively process it with depth + 1.  
The recursion naturally handles all nesting levels and accumulates the total weighted sum.  

**BFS**:
I do BFS level by level using a queue.  
Each level corresponds to one depth.  
I process all items at that level: add depth × value for integers, and enqueue child lists.  
Then I increment depth and continue.  

## 364. Nested List Weight Sum II
Need to memeorize the code! How to calculat max depth is tricky  
**Two DFS passes**:
I use two DFS passes.  
First, I compute the maximum nesting depth of the list.  
Then I do another DFS, passing the current depth.  
When I see an integer, I apply the inverse weight maxDepth − depth + 1 and add it to the sum.  
Lists recurse deeper with depth + 1.  
This guarantees deeper numbers get smaller weights  

**BFS**:
I use BFS level by level.  
I keep a running sum of all integers seen so far.  
After each level, I add that sum into the result.  
Shallow numbers stay in the running sum longer, so they’re added more times and get higher inverse weights  

**DFS one pass**
There is also a one-pass version using algebra:  
during DFS I track total sum, depth-weighted sum, and max depth,  
then apply a formula to compute the inverse-weighted result  

# Slidng Window
## 1004. Max Consecutive Ones III

## 76. Minimum Window Substring

# Skip List

## 617. Merge Two Binary Trees
