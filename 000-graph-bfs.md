# Graph BFS
1. [286. Walls and Gates](https://leetcode.com/problems/walls-and-gates)  
    No need to have set to record visited elements as cell's value is set as distance and check whether cell value is INF(meaning empty room) essentially eliminate visited nodes
    <details>

      ```python
      def wallsAndGates(self, rooms: List[List[int]]) -> None:
          INF = 2 ** 31 - 1
          queue = deque()
  
          for r in range(len(rooms)):
              for c in range(len(rooms[0])):
                  if rooms[r][c] == 0:
                      queue.append((r, c))
  
  
          while queue:
              row, col = queue.popleft()
  
              for rowOffset, colOffset in [(-1, 0), (0, 1), (1, 0), (0, -1)]:
                  nextRow = row + rowOffset
                  nextCol = col + colOffset
                  if nextRow < 0 or nextRow >= len(rooms) or nextCol < 0 or nextCol >= len(rooms[0]) or rooms[nextRow][nextCol] != INF:
                      continue
                  rooms[nextRow][nextCol] = rooms[row][col] + 1
                  queue.append((nextRow, nextCol))
      
      ```
    </details>
