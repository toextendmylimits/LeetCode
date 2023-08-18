# Design
1. [348. Design Tic-Tac-To](https://leetcode.com/problems/design-tic-tac-toe)  
   Key is to save sum of each row, each column, diagonal, anti diagonal  
   ***Time complexity O(1), space complexity O(N)***
   <details>

      ```python
          class TicTacToe:
          
              def __init__(self, n: int):
                  self.size = n
                  self.rowSum = [0] * n
                  self.colSum = [0] * n
                  self.diagSum = 0
                  self.antiDiagSum = 0
          
              def move(self, row: int, col: int, player: int) -> int:
                  n = self.size
                  toAdd = 1 if player == 1 else -1
                  self.rowSum[row] += toAdd
                  self.colSum[col] += toAdd
                  if row == col:
                      self.diagSum += toAdd
          
                  if row + col == n - 1:
                      self.antiDiagSum += toAdd
          
                  
                  if abs(self.rowSum[row]) == n or abs(self.colSum[col] ) == n or abs(self.diagSum) == n or abs(self.antiDiagSum) == n:
                      return player
                  else:
                      return 0
      ```
   </details>

1. [794. Valid Tic-Tac-Toe State](leetcode.com/problems/valid-tic-tac-toe-state)  
   Record whether X win or O win, and count of X, and O
   1. If both player X and O win, return False
   1. If player X win and count of X - count of O is not 1, return False
   1. If player O win and count of C is not equal to count of O, return False
   1. In the end, return 0 <= count of X - count of O <= 1  
   ***Time complexity O(N*2), space complexity O(N)***  
   <details>

      ```python
        def validTicTacToe(self, board: List[str]) -> bool:
           size = len(board)
           rowSum = [0] * size
           colSum = [0] * size
           diagSum = 0
           antiDiagSum = 0
           xCount = 0
           oCount = 0
           xWin = False
           oWin = False
           for r in range(size):
               for c in range(size):
                   cell = board[r][c]
                   toAdd = 0
                   if cell == "X":
                       toAdd = 1
                       xCount += 1
                   elif cell == "O":
                       toAdd = -1
                       oCount += 1
                   rowSum[r] += toAdd
                   colSum[c] += toAdd
                   if r == c:
                       diagSum += toAdd
                   
                   if r + c == size - 1:
                       antiDiagSum += toAdd
                   
                   for theSum in [rowSum[r], colSum[c], diagSum, antiDiagSum]:
                       if theSum == size:
                           xWin = True
                       if theSum == -size:
                           oWin = True
                   
           if xWin and oWin:
               return False
           elif xWin and not xCount - oCount == 1:
               return False
           elif oWin and not xCount == oCount:
               return False
           else:
               return 0 <= xCount - oCount <= 1
      ```
   </details>
   
1. [251. Flatten 2D Vector](https://leetcode.com/problems/flatten-2d-vector/)  
   ***Approach 1 - flatten vector in constructor and maintain cursor***  
   Time complexity O(N) where N represent the number of elements in the list, space complexity O(N) for constructor  
   Time complexity O(1) for next and hasNext, space complexity is O(N)  
   <details>

      ```python
      class Vector2D:   
          def flatten(self, vec):
              result = []
              for lst in vec:
                  for item in lst:
                      result.append(item)
              return result
          def __init__(self, vec: List[List[int]]):
              self.flattenList = self.flatten(vec)
              self.cursor = 0
          def next(self) -> int:
              if self.hasNext():
                  currCursor = self.cursor
                  self.cursor += 1
                  return self.flattenList[currCursor]
              else:
                  return -1
      
          def hasNext(self) -> bool:
              return self.cursor <= len(self.flattenList) - 1   
      ```
   </details>
   
   ***Approach 2 - main two pointers for outer position and inner position, advance in hasNext***  
   Time complexity O(1) and space complexity O(1) on average    
   <details>
      
      ```python
      class Vector2D:   
          def __init__(self, vec: List[List[int]]):
              self.innerPos = 0
              self.outerPos = 0
              self.vec = vec
      
          def next(self) -> int:
              if self.hasNext():
                  currInnerPos = self.innerPos
                  self.innerPos += 1
                  return self.vec[self.outerPos][currInnerPos]
              else:
                  return -1
      
          def hasNext(self) -> bool:
              while self.outerPos < len(self.vec) and self.innerPos == len(self.vec[self.outerPos]):
                  self.outerPos += 1
                  self.innerPos = 0
              
              return self.outerPos < len(self.vec)
      ```
   </details>

1. [380. Insert Delete GetRandom O(1)](https://leetcode.com/problems/insert-delete-getrandom-o1)   
   Key is to use hash map to find index of an element to delete, and then swap it with last element  
   ***Time complexity*** Getrandom O(1), insert and remove O(1) in general, and in worst case is O(N) when the operation exceeds the capacity of
currently allocated array/hashmap and invokes space reallocation.
   
   ***Space complexity*** O(N)  
   <details>

      ```python
         class RandomizedSet:
             def __init__(self):
                 self.valueIndexMap = {}
                 self.list = []
         
             def insert(self, val: int) -> bool:
                 if val in self.valueIndexMap:
                     return False
                 
                 self.valueIndexMap[val] = len(self.list)
                 self.list.append(val)
                 return True
                 
         
             def remove(self, val: int) -> bool:
                 if val not in self.valueIndexMap:
                     return False
         
                 idx = self.valueIndexMap[val]
                 lastElement = self.list[-1] 
                 self.list[idx] = lastElement
                 self.valueIndexMap[lastElement] = idx
         
                 del self.valueIndexMap[val]
                 self.list.pop()
                 return True
         
             def getRandom(self) -> int:
                 return self.list[random.randint(0, len(self.list) - 1)]
      ```
   </details>
   
