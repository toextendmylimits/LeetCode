
## 435. Non-overlapping Intervals

To minimize removals, I maximize the number of non-overlapping intervals.  
A greedy strategy works: sort by end time and always keep the interval that ends earliest  

## 102. Binary Tree Level Order Traversal
I use breadth-first search.   
I start from the root and process the tree level by level using a queue.   
For each level, I record all node values, then push their children into the queue.   
Each iteration produces one level of the result.  

## 236. Lowest Common Ancestor of a Binary Tree 
I traverse the tree bottom-up. If a node is one of the targets, I return it.  
I check both subtrees.  
If both sides find a target, the current node is the lowest common ancestor.  
Otherwise, I propagate the found node upward.

# DP
## 70. Climbing Stairs
To reach step n, the last move is either from n-1 or n-2.  
So the number of ways is the sum of those two.  
This forms a Fibonacci sequence, which I compute iteratively using two variables.  
