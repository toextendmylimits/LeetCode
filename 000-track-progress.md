
# Track progress
## 01/08/2023
|Question | Category | Comment
|----------|---------|---------
|[200. Number of Islands](https://leetcode.com/problems/number-of-islands)     |  Graph |
|[695. Max Area of Island](https://leetcode.com/problems/max-area-of-island)      |   Graph |   
|[79. Word Search](https://leetcode.com/problems/word-search)     |    Graph | 
|[286. Walls and Gates](https://leetcode.com/problems/walls-and-gates)       |   Graph |  
|[752. Open the Lock](https://leetcode.com/problems/open-the-lock)     |   Graph |   
|[127. Word Ladder](https://leetcode.com/problems/word-ladder)       |   Graph |    
|[542. 01 Matrix](https://leetcode.com/problems/01-matrix/)       |   Graph |    
|[994. Rotting Oranges](https://leetcode.com/problems/rotting-oranges)     |   Graph |    
|[133. Clone Graph](https://leetcode.com/problems/clone-graph)      |   Graph |    
|[105. Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal)      |   Graph |     
|[106. Construct Binary Tree from Inorder and Postorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal)       |   Graph | 
|[210. Course Schedule II](https://leetcode.com/problems/course-schedule-ii)  |    Graph |  
|[269. Alien Dictionary](https://leetcode.com/problems/alien-dictionary)  |  Graph |
|[203. Remove Linked List Elements](https://leetcode.com/problems/remove-linked-list-elements)  |  Linked List |
|[114. Flatten Binary Tree to Linked List](https://leetcode.com/problems/flatten-binary-tree-to-linked-list)  |  Tree DFS | Check whether node if leaf in base condition
|[237. Delete Node in a Linked List](https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list) | Linked List | Update node value and then connect node with its next's next
|[7. Reverse Integer](https://leetcode.com/problems/reverse-integer) | Strings | Beware python modulo operation with negative number for python -2 % 5 == 3 (NOT -2)

## 02/08/2023
|Question | Category | Comment
|----------|---------|---------
|[14. Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix)     |  String | 
|[28. Find the Index of the First Occurrence in a String](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string)   | String |
|[8. String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi) | String | Beware edge case when number overflow, always check against pow(2, 31) - 1, remember, the last digit of pow(2, 31) - 1 is 7, while last digit of pow(2, 31) is 8
|[125. Valid Palindrome](https://leetcode.com/problems/valid-palindrome) | String |
|[26. Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array) | Array |
|[283. Move Zeroes](https://leetcode.com/problems/move-zeroes) | Array |
|[189. Rotate Array](https://leetcode.com/problems/rotate-array) | Array | k %= len, then reverse three times to have O(1) space complexity
|[66. Plus One](https://leetcode.com/problems/plus-one)  | Array | Should practice this more to code it in two minutes
|[350. Intersection of Two Arrays II](https://leetcode.com/problems/intersection-of-two-arrays-ii)  | Array | Learn to sort the array, and then use two pointers
|[136. Single Number](https://leetcode.com/problems/single-number)  |Bitwise |

## 03/08/2023
Reviewed all the questions from previous day 02/08

Reviewd the following from 01/08:
|Question | Category | Comment
|----------|---------|---------
|[200. Number of Islands](https://leetcode.com/problems/number-of-islands)     |  Graph |
|[695. Max Area of Island](https://leetcode.com/problems/max-area-of-island)      |   Graph |   
|[79. Word Search](https://leetcode.com/problems/word-search)     |    Graph | Time: O(N*3^L) Space: O(L), N is number of cells, L is length of word; Remember use set to mark visited cell, and remove when backtracking |

## 04/08/2023

### Reviewed the following questions from 01/08
|Question | Category | Comment
|----------|---------|---------
|[286. Walls and Gates](https://leetcode.com/problems/walls-and-gates)       |   Graph |  
|[752. Open the Lock](https://leetcode.com/problems/open-the-lock)     |   Graph |   
|[127. Word Ladder](https://leetcode.com/problems/word-ladder)       |   Graph |  Remember to check whether word in wordSet, and initialize count to 0
|[542. 01 Matrix](https://leetcode.com/problems/01-matrix/)       |   Graph |    
|[994. Rotting Oranges](https://leetcode.com/problems/rotting-oranges)     |   Graph | Return 0 immediately if there is no fresh fruit at all in the beginning   
|[133. Clone Graph](https://leetcode.com/problems/clone-graph)      |   Graph |Remember to put new copy to oldToNew hash map, space compelxity is O(V) for hash map and recursion stack call  
|[210. Course Schedule II](https://leetcode.com/problems/course-schedule-ii)  |    Graph |  Space complexity O(V+E) for queue plus initial graph build
|[269. Alien Dictionary](https://leetcode.com/problems/alien-dictionary)  |  Graph |Rememboer to break when letters don't equal, and beware time complexity and space complexity
|[203. Remove Linked List Elements](https://leetcode.com/problems/remove-linked-list-elements)  |  Linked List | Two pointers, previous to dummy, curr to head
|[114. Flatten Binary Tree to Linked List](https://leetcode.com/problems/flatten-binary-tree-to-linked-list)  |  Tree DFS | Check whether node if leaf in base condition
|[237. Delete Node in a Linked List](https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list) | Linked List | Update node value and then connect node with its next's next
|[7. Reverse Integer](https://leetcode.com/problems/reverse-integer) | Strings | Beware python modulo operation with negative number for python -2 % 5 == 3 (NOT -2)

### Reviewed following questions for sliding window
|Question | Comment
|----------|---------
| [159. Longest Substring with At Most Two Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters)  |
|[340. Longest Substring with At Most K Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters)  |
|[643. Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i)  |
[209. Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum)  |Different to other questions, result is updated within while loop|
|[713. Subarray Product Less Than K](https://leetcode.com/problems/subarray-product-less-than-k)  | Remember to return 0 for edge case k <= 1, and right - left + 1 represent numbers of subarray starting at index greater than or equal to left, but ending at index right|
|[3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters)|DO it a few times|
|[904. Fruit Into Baskets](https://leetcode.com/problems/fruit-into-baskets)  |

## 05/08/2023

### Reviewed following questions for sliding window
|Question | Comment
|----------|---------
|[992. Subarrays with K Different Integers](https://leetcode.com/problems/subarrays-with-k-different-integers)    | in while loop, condition is: len(counter) > k
|[76. Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring)    | Check whether char is in origCounter first |
|[438. Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string)  |

### Reviewed following questions for trees
|Question | Comment
|[104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/)| BFS: depth is initialized to 0, and child null check is: if child(dont't make typo as if not child)|
|[98. Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree) |

