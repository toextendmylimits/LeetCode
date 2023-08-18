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
