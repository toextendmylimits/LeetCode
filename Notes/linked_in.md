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
DFS:
This is a recursive DFS on a binary search tree.  
At each node, I compare its value with both target values.  
If both targets are smaller, I recurse into the left subtree.  
If both are larger, I recurse into the right subtree.  
Otherwise, the current node is where the paths split, so it’s the lowest common ancestor.  

BFS:
Because this is a binary search tree, I can use its ordering.  
I start from the root and iterate downward.  
If both target nodes are smaller than the current node, I move left.  
If both are larger, I move right.  
The first node where they split—or match the current node—is the lowest common ancestor.  
