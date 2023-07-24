# Tree BFS
## Easy
1. [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal)  
1. [107. Binary Tree Level Order Traversal II](https://leetcode.com/problems/binary-tree-level-order-traversal-ii)  
   Do a normal level order traversal and then reverse
1. [637. Average of Levels in Binary Tree](https://leetcode.com/problems/average-of-levels-in-binary-tree)
1. [199. Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view)
   Only add the last item of each level to result
1. [103. Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal)  
   Have a flag for zig zag order, and use queue to save each level's result, as inserting at front is O(1) compared to O(n) for list
   Alternative more intutive approach is to reverse each level's result
1. [104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree)  
   Check whether depth means number of nodes or edges on longest path, then initialize depth to be 0 or -1
1. [111. Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree)  
1. [559. Maximum Depth of N-ary Tree](https://leetcode.com/problems/maximum-depth-of-n-ary-tree)
## Medium
1. [16. Populating Next Right Pointers in Each Node](https://leetcode.com/problems/populating-next-right-pointers-in-each-node)  
    1. approach 1 - Do a normal level order traversal, and create prev pointer for each level, connect next and update prev
1. [993. Cousins in Binary Tree](https://leetcode.com/problems/cousins-in-binary-tree)  
   save depth and parent of a child
   ```
    for child in [node.left, node.right]:
      if child:
         queue.append(child)
         if child.val == x:
             xParent = node
             xDepth = depth + 1
         if child.val == y:
             yParent = node
             yDepth = depth + 1
   
         if xDepth != -1 and yDepth != -1:
             return xDepth == yDepth and xParent != yParent
   ```
   1. [101. Symmetric Tree](https://leetcode.com/problems/symmetric-tree)
      Put pairs of nodes left and right to queue
      ```
      if not node1 and not node2:
          continue
      elif not node1 or not node2:
          return False
      elif node1.val != node2.val:
          return False

      queue.append(node1.left)
      queue.append(node2.right)
      queue.append(node1.right)
      queue.append(node2.left)
      ```
      

