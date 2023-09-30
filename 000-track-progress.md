

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
|[285. Inorder Successor in BST](https://leetcode.com/problems/inorder-successor-in-bst)| Second time, couldn't resolve it, practice more|
|[2. Add Two Numbers](https://leetcode.com/problems/add-two-numbers)|Coded it bug-free quickly for a second time |
|[328. Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list)| Coded it bug-free for the first time|
|[75. Sort Colors](https://leetcode.com/problems/sort-colors)  | Coded it bug-free for the first time |
|[347. Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements)| Coded it wrongly, Need more practice |
|[34. Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array)| Coded it bug-free for second time |
|[56. Merge Intervals](https://leetcode.com/problems/merge-intervals)|Coded bug-free for first time |
|[253. Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii)|Coded bug-free for second time|
|[33. Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array)| Coded it bug-free for first time|
|[74. Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix) | Coded it bug-free for the first time|
|[240. Search a 2D Matrix II](https://leetcode.com/problems/search-a-2d-matrix-ii) | Coded it bug-free for the first time |

## 16 - 17/08/2023
|Question | Comment
|----------|---------
|[348. Design Tic-Tac-To](https://leetcode.com/problems/design-tic-tac-toe) | Coded it with difficulty, need more practice |
|[297. Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) | Coded it with bug, need more practice |
[62. Unique Paths](https://leetcode.com/problems/unique-paths) | Didn't code it, need more practice |
|[55. Jump Game](https://leetcode.com/problems/jump-game/) | Didn't code it, need more practice |
|[150. Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation) | Coded it with bug, need more practice |
|[169. Majority Element](https://leetcode.com/problems/majority-element/)| Coded it with bug, need more practice |
|[69. Sqrt(x)](https://leetcode.com/problems/sqrtx/) | Coded it with bug, need more practice |
|[50. Pow(x, n)](https://leetcode.com/problems/powx-n/) | Didn't code, need more practice |
|[172. Factorial Trailing Zeroes](https://leetcode.com/problems/factorial-trailing-zeroes)| Didn't code it, need more practice |
|[202. Happy Number](https://leetcode.com/problems/happy-number/) | Didn't code it using fast/slow pointer, need more practice |

## 18/08/2023

### Reviewed questions from 16 - 17/08/2023
|Question | Comment
|----------|---------
|[348. Design Tic-Tac-To](https://leetcode.com/problems/design-tic-tac-toe) | Coded it with difficulty, need more practice |
|[297. Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) | Coded it with bug, need more practice |
[62. Unique Paths](https://leetcode.com/problems/unique-paths) | Didn't code it, need more practice |
|[55. Jump Game](https://leetcode.com/problems/jump-game/) | Didn't code it, need more practice |
|[150. Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation) | Coded it with bug, need more practice |
|[169. Majority Element](https://leetcode.com/problems/majority-element/)| Coded it with bug, need more practice |
|[69. Sqrt(x)](https://leetcode.com/problems/sqrtx/) | Coded it with bug, need more practice |
|[50. Pow(x, n)](https://leetcode.com/problems/powx-n/) | Didn't code, need more practice |
|[172. Factorial Trailing Zeroes](https://leetcode.com/problems/factorial-trailing-zeroes)| Didn't code it, need more practice |
|[202. Happy Number](https://leetcode.com/problems/happy-number/) | Didn't code it using fast/slow pointer, need more practice |

### New questions:
|Question | Comment
|----------|---------
|[380. Insert Delete GetRandom O(1)](https://leetcode.com/problems/insert-delete-getrandom-o1) | Didn't code it, need more practice |
|[794. Valid Tic-Tac-Toe State](https://leetcode.com/problems/valid-tic-tac-toe-state) | Didn't code it, need more practice |

## 19/08/2023

### Reviewed questions from 16 - 18/08/2023
|Question | Comment
|----------|---------
|[380. Insert Delete GetRandom O(1)](https://leetcode.com/problems/insert-delete-getrandom-o1) | Coded it bug-free for the first time |
|[794. Valid Tic-Tac-Toe State](https://leetcode.com/problems/valid-tic-tac-toe-state) | Coded it with bug due to wrong indent|
|[348. Design Tic-Tac-To](https://leetcode.com/problems/design-tic-tac-toe) | Coded it with difficulty, need more practice |
|[297. Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) | Coded it with bug, need more practice |
[62. Unique Paths](https://leetcode.com/problems/unique-paths) | Coded it with bug-free for first time |
|[55. Jump Game](https://leetcode.com/problems/jump-game/) | Coded it bug-free for the first time|
|[150. Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation) | Coded it bug-free for the first time |
|[169. Majority Element](https://leetcode.com/problems/majority-element/)| Coded it bug-free for the first time |
|[69. Sqrt(x)](https://leetcode.com/problems/sqrtx/) | Coded it bug-free, but almost forgot == in the condition, should be left <= right |
|[50. Pow(x, n)](https://leetcode.com/problems/powx-n/) | Coded it bug-free, but still need practice |
|[172. Factorial Trailing Zeroes](https://leetcode.com/problems/factorial-trailing-zeroes)| Coded it bug-free for first time, but still need more practice |
|[202. Happy Number](https://leetcode.com/problems/happy-number/) | Coded it with bug, condition is n != 0 not n % 10 != 0|
|[251. Flatten 2D Vector](https://leetcode.com/problems/flatten-2d-vector) | Coded it bug-free for the first time |

## 21/08/2023

|Question | Comment
|----------|---------
|[11. Container With Most Water](https://leetcode.com/problems/container-with-most-water)| More practice |
|[42. Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water) | More practice |
|[238. Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self) | More practice |

## 23/08/2023

### Reviewed questions from 21/08/2023
|Question | Comment
|----------|---------
|[11. Container With Most Water](https://leetcode.com/problems/container-with-most-water)| Coded it bug-free for the first time |
|[42. Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water) | Coded bug-free in 3 ways for the first time |
|[238. Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self) | Coded bug-free in 2 ways for the first time|
|[54. Spiral Matrix](https://leetcode.com/problems/spiral-matrix) | Coded it with serious issue, as forgetting resetting boundaries|

## 24 - 30/08/2023

|Question | Comment
|----------|---------
|[146. LRU Cache](https://leetcode.com/problems/lru-cache)| Struggling|

### Reviewed questions from easy list
|Question | Comment
|----------|---------
|[26. Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array) | Coded it bug-free, but spent nearly 5 minutes |
|[1. Two Sum](https://leetcode.com/problems/two-sum)| Coded it bug-free, took 2 minutes |
|[122. Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii)| Coded it bug-free, spent 2 minutes |
|[189. Rotate Array](https://leetcode.com/problems/rotate-array)| Coded it bug-free, but was hesitant a bit, should practice more |
|[217. Contains Duplicate](https://leetcode.com/problems/contains-duplicate) | Coded it bug-free using hash set but should practice more with sorting as well |
|[136. Single Number](https://leetcode.com/problems/single-number/)| Coded it bug-free easily but should still practice more |
|[350. Intersection of Two Arrays II](https://leetcode.com/problems/intersection-of-two-arrays-ii) | Coded with bug, should practice more |
|[283. Move Zeroes](https://leetcode.com/problems/move-zeroes)| Coded it bug-free |
|[36. Valid Sudoku](https://leetcode.com/problems/valid-sudoku)| Coded it bug-free, but should practice more with explaining the algorithm | 
|[48. Rotate Image](https://leetcode.com/problems/rotate-image)| Coded bug-free, but should practice more |
|[387. First Unique Character in a String](https://leetcode.com/problems/first-unique-character-in-a-string) | Coded it bug-free, still practice more |
|[242. Valid Anagram](https://leetcode.com/problems/valid-anagram) | Coded it bug-free, still practice more |
|[Valid Plalindrome](https://leetcode.com/problems/valid-palindrome) | Coded bug-free, still practice more |
|[28. Find the Index of the First Occurrence in a String](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string) | Coded bug-free, still practice more |
|[7. Reverse Integer](https://leetcode.com/problems/reverse-integer)| Coded it okay, but better practice more |
|[8. String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi)| Coded it with serious defect and spent almost 10 minutes, should practice more |
|[14. Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix)|Coded it bug-free, but wasn't 100% clear, should practice more |
|[19. Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list)|Coded it bug-free, but wasn't 100% clear, practice more |
|[206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list) | Coded it bug-free, but could improve, practice more |
|[21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists)| Coded it bug-free, but not 100% clear, practice more |
|[141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle) | Coded it bug-free, but should still practice more |
|[104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree)| Coded it wrongly with BFS, use popleft instead of pop for queue |
|[98. Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree) | Coded it bug-free, but should practice more |
|[101. Symmetric Tree](https://leetcode.com/problems/symmetric-tree)| Coded it bug-free, practice more |
|[102. Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal) | Coded it bug-free |
|[108. Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree)| Coded it with bug |
|[88. Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array)| Coded it bug-free |
|[278. First Bad Version](https://leetcode.com/problems/first-bad-version)| Coded bug-free |
|[384. Shuffle an Array](https://leetcode.com/problems/shuffle-an-array)| Coded with serious issue, fogot randint, should practice more |
|[155. Min Stack](https://leetcode.com/problems/min-stack)|Coded bug-free, better practice more though |
|[412. Fizz Buzz](https://leetcode.com/problems/fizz-buzz)|Coded bug-free easily, no need to practice |
|[326. Power of Three](https://leetcode.com/problems/power-of-three) | Coded bug-free, but better practice more |
|[13. Roman to Integer](https://leetcode.com/problems/roman-to-integer)| Coded bug-free easily, may practice one last time |
|[204. Count Primes](https://leetcode.com/problems/count-primes)| Failed, need more practice |
|[268. Missing Number](https://leetcode.com/problems/missing-number) | Not very clear, need more practice |
|[20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses) | Coded with defect, need more practice |
|[191. Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits)| Coded with difficult, need more practice |
|[461. Hamming Distance](https://leetcode.com/problems/hamming-distance)| Coded with difficulty, need more practice |
|[190. Reverse Bits](https://leetcode.com/problems/reverse-bits)| Coded with difficulty, need more practice, beware loop 32 times |
|[118. Pascal's Triangle](https://leetcode.com/problems/pascals-triangle)  | Coded with bug, need more practice, beware boundary col in range(1, row) |
|[70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs)| Coded bug-free, better still practice more |
|[121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock) | Coded bug-free, better still practice more |
|[53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray)|Coded bug-free, but should practice more and aim to explain clearly |
|[198. House Robber](https://leetcode.com/problems/house-robber)| Coded with bug, need more practice |

## 31/08/2023

### Did questions about cylic sort
|Question | Comment
|----------|---------
|[268. Missing Number](https://leetcode.com/problems/missing-number) | Coded wrongly, practice more |
|[41. First Missing Positive](https://leetcode.com/problems/first-missing-positive)| rightPos = nums[i] - 1 |
|[287. Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number)|
|[645. Set Mismatch](https://leetcode.com/problems/set-mismatch)|
### Reviewed questions from medium list
|Question | Comment
|----------|---------
|[3 sum](https://leetcode.com/problems/3sum) | Coded wrongly, beware left = i + 1, and boundary check when changing left or right: while left < right and nums[left] == nums[left - 1] |

## 01/09/2023

### Did questions about cylic sort
|Question | Comment
|----------|---------
|[26. Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array) | Coded it bug-free easily |
|[1. Two Sum](https://leetcode.com/problems/two-sum)| Coded it bug-free easily  |
|[122. Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii)| Coded it bug-free easily  |
|[189. Rotate Array](https://leetcode.com/problems/rotate-array)| Coded it bug-free easily |
|[217. Contains Duplicate](https://leetcode.com/problems/contains-duplicate) | Coded it with silly bug|
|[136. Single Number](https://leetcode.com/problems/single-number/)| Coded it bug-free easily |
|[350. Intersection of Two Arrays II](https://leetcode.com/problems/intersection-of-two-arrays-ii) | Coded it bug-free easily |
|[283. Move Zeroes](https://leetcode.com/problems/move-zeroes)| Coded it bug-free easily, beweare approach 2 of minimizing operations |
|[36. Valid Sudoku](https://leetcode.com/problems/valid-sudoku)| Coded it wrongly, practice more| 
|[48. Rotate Image](https://leetcode.com/problems/rotate-image)| Coded it bug-free easily |
|[387. First Unique Character in a String](https://leetcode.com/problems/first-unique-character-in-a-string) | Coded it bug-free easily|
|[242. Valid Anagram](https://leetcode.com/problems/valid-anagram) | Coded it bug-free easily |
|[125. Valid Palindrome](https://leetcode.com/problems/valid-palindrome) | Coded with silly bug, right should be len(nums) - 1 |
|[28. Find the Index of the First Occurrence in a String](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string) | Coded it bug-free easily |
|[7. Reverse Integer](https://leetcode.com/problems/reverse-integer)| Coded it correctly using Java |
|[8. String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi)| Read code again |
|[14. Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix)|Coded it bug-free easily |
|[19. Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list)|Coded it bug-free, but was little hesitant, practice more|
|[206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list) | Coded it bug-free easily |
|[21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists)| Coded it bug-free easily |
|[141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle) | Coded it bug-free easily |
|[104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree)| Coded it bug-free easily |
|[98. Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree) | Coded it bug-free easily |
|[101. Symmetric Tree](https://leetcode.com/problems/symmetric-tree)| Coded it bug-free easily |
|[102. Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal) | Coded it bug-free easily |
|[108. Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree)| Coded it bug-free easily |
|[88. Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array)| Coded it bug-free easily |
|[278. First Bad Version](https://leetcode.com/problems/first-bad-version)| Coded it bug-free easily |
|[384. Shuffle an Array](https://leetcode.com/problems/shuffle-an-array)| Coded with bug |
|[155. Min Stack](https://leetcode.com/problems/min-stack)|Coded it bug-free easily |
|[412. Fizz Buzz](https://leetcode.com/problems/fizz-buzz)|Too easy, just read the code |
|[326. Power of Three](https://leetcode.com/problems/power-of-three) | Coded it bug-free easily |
|[13. Roman to Integer](https://leetcode.com/problems/roman-to-integer)| Coded bug-free easily, no need to practice again |
|[204. Count Primes](https://leetcode.com/problems/count-primes)| Coded it bug-free easily, but need more practice |
|[268. Missing Number](https://leetcode.com/problems/missing-number) | Coded it bug-free easily |
|[20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses) | Coded it bug-free easily |
|[191. Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits)| Coded it bug-free easily |
|[461. Hamming Distance](https://leetcode.com/problems/hamming-distance)|Coded it bug-free easily|
|[190. Reverse Bits](https://leetcode.com/problems/reverse-bits)| Coded it bug-free easily |
|[118. Pascal's Triangle](https://leetcode.com/problems/pascals-triangle)  | Coded it bug-free easily |
|[70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs)| Coded it bug-free easily |
|[121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock) | Coded it bug-free easily |
|[53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray)|Coded it bug-free easily |
|[198. House Robber](https://leetcode.com/problems/house-robber)| Coded it bug-free easily |
|[1539. Kth Missing Positive Number](https://leetcode.com/problems/kth-missing-positive-number) | Didn't code it, more practice |

## 03/09/2023

### Did questions about medium list
|Question | Comment
|----------|---------
|[94. Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/) | Coded bug-free easily |
|[103. Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal)| Coded bug-free easily |
|[105. Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal)| Coded with difficulty, more practice |
|[230. Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst)| Coded wrongly, more practice, and also learn other ways |
|[116. Populating Next Right Pointers in Each Node](https://leetcode.com/problems/populating-next-right-pointers-in-each-node)| Should learn how to use next pointer | 
|[285. Inorder Successor in BST](https://leetcode.com/problems/inorder-successor-in-bst)| Failed, more practice |
|[733. Flood Fill](https://leetcode.com/problems/flood-fill)| More practice |
|[Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number)| Coded with bug, beware edge case when there is digit |
|[22. Generate Parentheses](https://leetcode.com/problems/generate-parentheses)| Coded with issue, more practice |
|[46. Permutations](https://leetcode.com/problems/permutations)| Coded bug-free, more practice |
|[78. Subsets](https://leetcode.com/problems/subsets) | Coded bug-free, more practice |
|[79. Word Search](https://leetcode.com/problems/word-search) | Coded with bug, more practice |
|[75. Sort Colors](https://leetcode.com/problems/sort-colors) | Coded wrongly, more practice |
|[347. Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements)| Coded bug-free |
|[33. Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array) | Failed, more practice |
|[240. Search a 2D Matrix II](https://leetcode.com/problems/search-a-2d-matrix-ii) | Coded bug-free, but not very familiar, more practice |
|[56. Merge Intervals](https://leetcode.com/problems/merge-intervals)| Coded bug-free, but better practice more |
|[253. Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii) | Coded bug-free, still practice more |
|[297. Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree)| Coded bug-free, but not familiar, practice more |
|[380. Insert Delete GetRandom O(1)](https://leetcode.com/problems/insert-delete-getrandom-o1) | Coded bug-free, practice more |
|[348. Design Tic-Tac-Toe](https://leetcode.com/problems/design-tic-tac-toe)| Failed, practice more |

## 06 - 07/09/2023

### Did remaining questions about medium list
|Question | Comment
|----------|---------
|[251. Flatten 2D Vector](https://leetcode.com/problems/flatten-2d-vector/) | Failed, advance inner in next, and advance outer and set inner to 0 in hasNext if inner is out of boundary |
|[202. Happy Number](https://leetcode.com/problems/happy-number)| Coded bug-free, should still practice more |
|[171. Excel Sheet Column Number](https://leetcode.com/problems/excel-sheet-column-number)| Coded bug-free, no need to practice |
|[69. Sqrt(x)](https://leetcode.com/problems/sqrtx) | Coded bug-free, no need to practice |
|[50. Pow(x, n)](https://leetcode.com/problems/powx-n) | Failed, more practice |
|[172. Factorial Trailing Zeroes](https://leetcode.com/problems/factorial-trailing-zeroes) | Coded bug-free, more practice |
|[169. Majority Element](https://leetcode.com/problems/majority-element)| Failed, more practice |
|[150. Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation)| Coded with defect, more practice |
|[55. Jump Game](https://leetcode.com/problems/jump-game) | Coded bug-free, but should practice more |
|[62. Unique Paths](https://leetcode.com/problems/unique-paths)| Coded with defect, should practice more |
|[5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring) | Failed, practice more |
|[322. Coin Change](https://leetcode.com/problems/coin-change) | Failed, practice more |
|[334. Increasing Triplet Subsequence](https://leetcode.com/problems/increasing-triplet-subsequence)| Failed, practice more |

## 10/09/2023

### Did top 150 interview list
|Question | Comment
|----------|---------
|[392. Is Subsequence](https://leetcode.com/problems/is-subsequence)| Coded bug-free, but not familiar, should practice more, also think about followup |
|[15. 3Sum](https://leetcode.com/problems/3sum)|Coded with defect, append() not append[]|
|[42. Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water)| Coded with defect, forgot to increase left or decrease right |
|[13. Roman to Integer](https://leetcode.com/problems/roman-to-integer)| Coded with defect, beware when currVal == nextVal, should add not substract currVal |
|[380. Insert Delete GetRandom O(1)](https://leetcode.com/problems/insert-delete-getrandom-o1)| Coded with defect, beware return True/False for insert and remove, also use del instead of delete to remove key from map |
|[238. Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self)| Coded with defect, beware for loop starting from end, in range(len(s) - 1(Not -1), -1, -1) |
|[58. Length of Last Word](https://leetcode.com/problems/length-of-last-word)| Coded wrongly, more practice |
|[14. Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix) | Coded wrongly, more practice |
|[103. Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal)| Coded wrongly, beware how to reverse array either level.reverse()(which returns null) or level = level[::-1] |
|[383. Ransom Note](https://leetcode.com/problems/ransom-note)|Coded bug-free, beware TC O(magazine length), SC O(1) as there are only 26 chracters | 
|[392. Is Subsequence](https://leetcode.com/problems/is-subsequence)| Coded correctly, but need to memorize the code |
|[104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree)| Coded with silly mistake, root.right not self.right, practice more |
|[100. Same Tree](https://leetcode.com/problems/same-tree)| Coded with silly mistake for BFS, return True in end, more practice |
|[226. Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree)| Coded bug-free, but not 100% clear, practice more |
|[105. Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal)| Not 100% clear with having preStart, preEnd, inStart, inEnd, practice more |
|[112. Path Sum](https://leetcode.com/problems/path-sum)| Coded wrongly, beware base condition, practice more | 

## 19/09/2023

### Did top 150 interview list
|Question | Comment
|----------|---------
|[36. Valid Sudoku](https://leetcode.com/problems/valid-sudoku/)| Coded with error, set not Set, dont forget range()|
|[48. Rotate Image](https://leetcode.com/problems/rotate-image/)| Coded bug-free|
|[73. Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes)| Coded with defect, set flag for first row and first column|
|[242. Valid Anagram](https://leetcode.com/problems/valid-anagram)| Coded with defect, use bracket for accesing hash map not parenthesis|
|[49. Group Anagrams](https://leetcode.com/problems/group-anagrams)| Coded bug-free easily, but better practice more|
|[202. Happy Number](https://leetcode.com/problems/happy-number) | Coded bug-free, but better practice more, and beware time complexity is O(logN)|
|[219. Contains Duplicate II](https://leetcode.com/problems/contains-duplicate-ii/)| Didn't code it, practice more |
|[205. Isomorphic Strings](https://leetcode.com/problems/isomorphic-strings) | More practice |
|[290. Word Pattern](https://leetcode.com/problems/word-pattern/) | More practice |
|[20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses) | Coded bug-free easily |
|[150. Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation) | Coded with defect, practice more and beware int/str conversion |
|[155. Min Stack](https://leetcode.com/problems/min-stack/) | Coded bug-free, practice more |
|[35. Search Insert Position](https://leetcode.com/problems/search-insert-position) | Coded bug-free, practice more |
|[33. Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array) | Coded it bug-free, but still practice more |
|[153. Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array) | Didn't code it, more practice |
|[74. Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix) | Coded wrongly, more practice |
|[17. Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number) | Coded it wrongly, more practice |
|[17. Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number)| Coded with defect, more practice |
|[46. Permutations](https://leetcode.com/problems/permutations) | Coded bug-free, more practice |
|[39. Combination Sum](https://leetcode.com/problems/combination-sum) | Coded bug-free, better practice more |
|[22. Generate Parentheses](https://leetcode.com/problems/generate-parentheses/) | Coded bug-free, better practice more |
|[79. Word Search](https://leetcode.com/problems/word-search) | Coded bug-free, better practice more |
|[141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle) | Coded, but not smooth, better practice more |
|[2. Add Two Numbers](https://leetcode.com/problems/add-two-numbers/) | Coded easily, better practice one last time |
|[21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists) | Coded easily, better practice one last time |
|[19. Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list) | Coded easily, better practice one last time |
|[67. Add Binary](https://leetcode.com/problems/add-binary) | Coded with error, beware "".join can't be used for int array directly, practice more |
|[190. Reverse Bits](https://leetcode.com/problems/reverse-bits) | Coded with error, beware loop 32 times, left shift equals to multiply, right shift equals to divide, practice more | 
|[191. Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits) | Coded bug-free, better practice more |
|[136. Single Number](https://leetcode.com/problems/single-number/) | Coded bug-free easily, better practice one last time |
|[56. Merge Intervals](https://leetcode.com/problems/merge-intervals) | Coded bug-free, better practice more | 
|[57. Insert Interval](https://leetcode.com/problems/insert-interval/) | Didn't code it, more practice | 
|[452. Minimum Number of Arrows to Burst Balloons](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/) | Didn't code it, more practice |

## 28/09/2023

### Did top 150 interview list
|Question | Comment
|----------|---------
|[66. Plus One](https://leetcode.com/problems/plus-one) | Coded it wrongly, more practice, beware // for divide |
|[108. Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree) | Coded it, but better practice more. TC O(N), SC O(logN)|
|[53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray) | Coded bug-free easily, but better practice more |
|[70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs) | Coded bug-free easily |
|[198. House Robber](https://leetcode.com/problems/house-robber) | Coded bug-free easily, but better practice more with writing the code concisely |
|[322. Coin Change](https://leetcode.com/problems/coin-change) | Coded bug-free, but need to practice more to better undertand the issue, also beware TC O(S*C), and SC O(S)|
|[5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring) | Coded bug-free, but not very clear, practice more |
|[98. Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree) | Coded wrongly, more practice |
|[215. Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array) | Coded with defect, more practice. To get top of heap, use heap[0] |
|[230. Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/) | Coded bug-free, but not 100% clear, more practice, beware TC and SC |
|[200. Number of Islands](https://leetcode.com/problems/number-of-islands) | Coded bug-free, but need more practice with BFS, don't forget mark as visited when visiting neighbours |
|[133. Clone Graph](https://leetcode.com/problems/clone-graph/) | Coded bug-free, but not 100% clear, more practice |
|[207. Course Schedule](https://leetcode.com/problems/course-schedule/) | Didn't code it, more practice |
|[210. Course Schedule II](https://leetcode.com/problems/course-schedule-ii) | Coded bug-free, but not familiar, more practice |

## 29/09/2023

### Did top 150 interview list remaining difficult ones
|Question | Comment
|----------|---------
|[80. Remove Duplicates from Sorted Array II](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii) | Didn't code it, more practice |
|[12. Integer to Roman](https://leetcode.com/problems/integer-to-roman)| Didn't code it, more practice |
|[151. Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string) | Didn't code it, should memorize the code |
|[45. Jump Game II](https://leetcode.com/problems/jump-game-ii) | Didn't code it, need to memorize the code |
