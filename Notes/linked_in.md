## 17. Letter Combinations of a Phone Number

Each digit maps to letters. I use backtracking: starting from the first digit,   
I try every mapped letter, append it to the current string, recurse to the next digit,   
and when I reach the end, I add the built string to the result.   
If the input is empty, I return an empty list.

## 1644. Lowest Common Ancestor of a Binary Tree II
I do a bottom-up traversal like the normal LCA problem, returning a node when I find either target.
At the same time, I track whether each target node is actually found in the tree.
If both are found, I return the split point as the LCA; otherwise, I return null.

Memorize the code.
