

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
|----------|---------
|[104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/)| BFS: depth is initialized to 0, and child null check is: if child(dont't make typo as if not child)|
|[98. Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree) |
|[101. Symmetric Tree](https://leetcode.com/problems/symmetric-tree) | To check either child is null: if not node.left or not node.right(Don't miss one not)|
|[108. Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree)  |Base condition: if left > right: return None |
|[Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal)  | Learn iterative way later |
|[103. Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/) |
|[105. Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal)   |
|[116. Populating Next Right Pointers in Each Node](https://leetcode.com/problems/populating-next-right-pointers-in-each-node) | Made two mistakes: 1. wrongly adding not for null check 2. Not return root |

### Reviewed following questions
|Question | Comment
|----------|---------
|[36. Valid Sudoku](https://leetcode.com/problems/valid-sudoku/)|Practice a few more times |
|[48. Rotate Image](https://leetcode.com/problems/rotate-image) | tranpose c start from r + 1, reflect c range to len // 2, need practice more |
|[326. Power of Three](https://leetcode.com/problems/power-of-three) | memorize the code |
|[13. Roman to Integer](https://leetcode.com/problems/roman-to-integer/) | Made mistake of letterToValueMap[-1] should be ***letterToValueMap[s[-1]]***|

### Reviewed following questions for Linked List
|Question | Comment
|----------|---------
|[237. Delete Node in a Linked List](https://leetcode.com/problems/delete-node-in-a-linked-list) |
|[206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list) |
|[19. Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list) | Should do a few more times
|[21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists)|
|[234. Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list)|Made mistake of having indefinite loop, practice more|

## 06/08/2023 - mainly reviewed questions form 05/08

### Reviewed following questions for sliding window
|Question | Comment
|----------|---------
|[992. Subarrays with K Different Integers](https://leetcode.com/problems/subarrays-with-k-different-integers)    | in while loop, condition is: len(counter) > k
|[76. Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring)    | Made mistake of using = instead of == for comparison, and not increasing left |
|[438. Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string)  | Made mistake of checking right - left + 1 == len(counter) (Should be against len(p))|

## 07/08/2023

### Reviewed following questions
|Question | Comment
|----------|---------
|[384. Shuffle an Array](https://leetcode.com/problems/shuffle-an-array) | Memorize methods to get random number |
|[155. Min Stack](https://leetcode.com/problems/min-stack) | Memorize the code |
|[88. Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array)  | Memorize code |
|[232. Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks)  | Practice more times |
|[225. Implement Stack using Queues](https://leetcode.com/problems/implement-queue-using-stacks)  | Practice more times |
|[204. Count Primes](https://leetcode.com/problems/count-primes)  | Memorize code |
|[20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses) | Memorize code |
|[118. Pascal's Triangle](https://leetcode.com/problems/pascals-triangle)  | Memorize code | 
|[268. Missing Number](https://leetcode.com/problems/missing-number) | Memorize different ways |
|[190. Reverse Bits](https://leetcode.com/problems/reverse-bits)| Memorize how bitwise shift correspond to divide, multiply, modulo |
|[191. Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits) |

## 09/08/2023

### Reviewed following questions
|Question | Comment
|----------|---------
|[461. Hamming Distance](https://leetcode.com/problems/hamming-distance) | 
|[70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs)| 
[121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock)  |
|[198. House Robber](https://leetcode.com/problems/house-robbe)| |
|[15. 3Sum](https://leetcode.com/problems/3sum)|Coded it bug-free quickly |
|[73. Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes)| Coded it with bug, practice more |
|[3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters)| Coded it with bug, practice more |
|[49. Group Anagrams](https://leetcode.com/problems/group-anagrams)| |
|[5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring)| Should memorize code |

## 10/08/2023

### Reviewed following questions from previous day 09/08/2023
|Question | Comment
|----------|---------
|[461. Hamming Distance](https://leetcode.com/problems/hamming-distance) | Coded it quickly |
|[70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs)| Coded it quickly | 
[121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock)  | Coded it quickly |
|[198. House Robber](https://leetcode.com/problems/house-robbe)| Coded it quickly |
|[15. 3Sum](https://leetcode.com/problems/3sum)|Coded it with serious bug, left should be i + 1 not 0, check whether nums[right] == nums[right + 1](not right - 1) |
|[73. Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes)| No bug |
|[3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters)| Coded it with bug, practice more |
|[49. Group Anagrams](https://leetcode.com/problems/group-anagrams)| Coded it right, but took a while, so needs more practice |
|[5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring)| Coded it with error, use: end - start + 1(not right - left + 1)|

Did a few questions:
|Question | Comment
|----------|---------
|[163. Missing Ranges](https://leetcode.com/problems/missing-ranges)  | Coded it very bug, practice more |
|[38. Count and Say](https://leetcode.com/problems/count-and-say) | First time, got it wrong |
|[17. Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number)| Coded it quickly |
|[22. Generate Parentheses](https://leetcode.com/problems/generate-parentheses) | Coded it quickly |
|[46. Permutations](https://leetcode.com/problems/permutations)| Coded it quickly |

## 11/08/2023
|Question | Comment
|----------|---------
|[78. Subsets](https://leetcode.com/problems/subsets) | Coded it quickly |
|[79. Word Search](https://leetcode.com/problems/word-search) | Had some issues, need more practice |
|[230. Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst)| First time, couldn't resolve it, practice more|
|[285. Inorder Successor in BST](https://leetcode.com/problems/inorder-successor-in-bst)| First time, couldn't resolve it, practice more|
|[2. Add Two Numbers](https://leetcode.com/problems/add-two-numbers)|Coded it bug-free quickly |
|[328. Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list)| Didn't solve it, need more practice |
|[75. Sort Colors](https://leetcode.com/problems/sort-colors)  | Got it wrong, beware while white <= blue(not white < blue), need more practice |
|[347. Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements)| Need more practice |
|[34. Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array)| Coded it bug-free |
|[56. Merge Intervals](https://leetcode.com/problems/merge-intervals)|Coded with error, more practice |
|[253. Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii)|Coded bug-free|
|[33. Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array)| Didn't code it, need more practice |
|[74. Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix) | Didn't solve it, need more practice |
|[240. Search a 2D Matrix II](https://leetcode.com/problems/search-a-2d-matrix-ii) | Didn't solve it, need more practice |

## 13/08/2023

### Reviewed questions from 11/08/2023
|Question | Comment
|----------|---------
|[78. Subsets](https://leetcode.com/problems/subsets) | Coded it quickly, twice |
|[79. Word Search](https://leetcode.com/problems/word-search) | Coded it wrongly, forgot to check for each cell of board, need more practice|
|[230. Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst)| Second time, couldn't resolve it, practice more|
|[285. Inorder Successor in BST](https://leetcode.com/problems/inorder-successor-in-bst)| First time, couldn't resolve it, practice more|
|[2. Add Two Numbers](https://leetcode.com/problems/add-two-numbers)|Coded it bug-free quickly |
|[328. Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list)| Didn't solve it, need more practice |
|[75. Sort Colors](https://leetcode.com/problems/sort-colors)  | Got it wrong, beware while white <= blue(not white < blue), need more practice |
|[347. Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements)| Need more practice |
|[34. Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array)| Coded it bug-free |
|[56. Merge Intervals](https://leetcode.com/problems/merge-intervals)|Coded with error, more practice |
|[253. Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii)|Coded bug-free|
|[33. Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array)| Didn't code it, need more practice |
|[74. Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix) | Didn't solve it, need more practice |
|[240. Search a 2D Matrix II](https://leetcode.com/problems/search-a-2d-matrix-ii) | Didn't solve it, need more practice |

