# Graph
## DFS
1.  [1254. Number of Closed Islands](https://leetcode.com/problems/number-of-closed-islands)
1.  [733. Flood Fill](https://leetcode.com/problems/flood-fill)  
    Beware the edge case when original color is same with replacement color, as it leads to infinite recursive stack call, so should return image immediately if original color is same as replacement color
    <details>

      ```python
      def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
          origColor = image[sr][sc]
          if origColor == color:
              return image
  
          def dfs(image, row, col, origColor, newColor):
              if row >= len(image) or row < 0 or col >= len(image[0]) or col < 0 or image[row][col] != origColor:
                  return
  
              image[row][col] = newColor
              offsets = [(-1, 0), (0, 1), (1, 0), (0, -1)]
              for offset in offsets:
                  dfs(image,row + offset[0], col + offset[1], origColor, newColor)
                   
          dfs(image, sr, sc, image[sr][sc], color)
          return image   
      ```
    </details>
1.  [200. Number of Islands](https://leetcode.com/problems/number-of-islands)  
    ***Approach 1 - DFS***
    Time complexity and space complexity is O(R * C) because each node is visited only once where R is number of rows and C is number of columns
    <details>

      ```python
        def numIslands(self, grid: List[List[str]]) -> int:
            def dfs(row, col):
                nonlocal grid
                if row < 0 or row >= len(grid) or col < 0 or col >= len(grid[0]) or grid[row][col] != "1":
                    return
    
                grid[row][col] = "0" # mark as visited
                for offset in [(-1, 0), (0, 1), (1, 0), (0, -1)]:
                    rowOffset, colOffset = offset
                    dfs(row + rowOffset, col + colOffset)
    
            count = 0
            for r in range(len(grid)):
                for c in range(len(grid[0])):
                    if grid[r][c] == "1":
                        count += 1
                        dfs(r, c)
    
            return count  
      ```
    </details>  

    ***Approach 1 - BFS***
    Time complexity and space complexity is O(R * C) because each node is visited only once where R is number of rows and C is number of columns
    <details>

      ```python
        def numIslands(self, grid: List[List[str]]) -> int:
            rowsCount = len(grid)
            colsCount = len(grid[0])
            count = 0
    
            def bfs(row, col):
                queue = deque([(row, col)])
                grid[row][col] = "0"
                while queue:
                    currRow, currCol = queue.popleft()
                    for rowOffset, colOffset in [(-1, 0), (0, 1), (1, 0), (0, -1)]:
                        nextRow = currRow + rowOffset
                        nextCol = currCol + colOffset
                        if 0 <= nextRow < len(grid) and 0 <= nextCol < len(grid[0]) and grid[nextRow][nextCol] == "1":
                            queue.append((nextRow, nextCol))
                            grid[nextRow][nextCol] = "0"
    
            for r in range(rowsCount):
                for c in range(colsCount):
                    if grid[r][c] == "1":
                        count += 1
                        bfs(r, c)
            
            return count
      ```
    </details>      
1.  [695. Max Area of Island](https://leetcode.com/problems/max-area-of-island)    
    The dfs method should return the area  
    Time complexiy and space complexity is O(R * C) where R is number of rows, and C is number of columns
    <details>

      ```python
        def getArea(self, grid, row, col):
            if row < 0 or row >= len(grid) or col < 0 or col >= len(grid[0]) or grid[row][col] != 1:
                return 0
    
            area = 1
            grid[row][col] = 0
            directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]
            for rowOffset, colOffset in directions:
                area += self.getArea(grid, row + rowOffset, col + colOffset)
            return area
    
        def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
            result = 0
            for r in range(len(grid)):
                for c in range(len(grid[0])):
                    if grid[r][c] == 1:
                        result = max(result, self.getArea(grid, r, c))
    
            return result 
      ```
    </details>
1.  [133. Clone Graph](https://leetcode.com/problems/clone-graph)    
    Clone the nodes recruisively  
    Need hash map to map new node to cloned node, so when a node is cloned already, next time we can just reference its cloned value
    ***Time complexiy*** is Time Complexity: O(V+E), where V is a number of nodes (vertices) and E is a number of edges.    
    ***Space complexity*** is O(V). This space is occupied by the  hash map and in addition to that, space would also be occupied by the recursion stack O(H) where H is the height of the graph.
    <details>

      ```python
        def cloneGraph(self, node: 'Node') -> 'Node':
            oldToNewMap = {}
            def clone(node):
                if not node:
                    return None
                    
                if node in oldToNewMap:
                    return oldToNewMap[node]
                
                copy = Node(node.val)
                oldToNewMap[node] = copy
                for nei in node.neighbors:
                    copy.neighbors.append(clone(nei))
                
                return copy
            return clone(node)
      ```
    </details>
## Backtracking
1. [79. Word Search](https://leetcode.com/problems/word-search)  
    For each of the cells, check whether there is a sequence starting from that cell using backtracking.   
    ***Beware to remove the visited node from set from backtracking***  
    ***Time Complexity***: O(N * 3 ^ L ) where N is the number of cells in the board and L is the length of the word to be matched. For the backtracking function, initially we could have at most 4 directions to explore, but further the choices are reduced into 3 (since we won't go back to where we come from).  
    ***Space Complexity***: O(L) for the visited set and recruision call stack
    <details>

      ```python
        def exist(self, board: List[List[str]], word: str) -> bool:
            visited = set()
    
            def backtrack(row, col, letterIndex):
                if letterIndex == len(word):
                    return True
                
                if row < 0 or row >= len(board) or col < 0 or col >= len(board[0]) or (row, col) in visited or board[row][col] != word[letterIndex]:
                    return False
    
                visited.add((row, col))
                for rowOffset, colOffset in [(-1, 0), (0, 1), (1, 0), (0, -1)]:
                    if backtrack(row + rowOffset, col + colOffset, letterIndex + 1):
                        return True
                visited.remove((row, col))
                return False
            
            for r in range(len(board)):
                for c in range(len(board[0])):
                    if backtrack(r, c, 0):
                        return True
    
            return False 
      ```
    </details>
## BFS
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

1. [752. Open the Lock](https://leetcode.com/problems/open-the-lock)  
    ***Beware to check whether the initial state is in dead locks, and if so, return immediately.***  
    ***Time complexity*** O(10^N*(N^2) + D) where N is the number of digits, D is the nubmer of deadlocks. There are 10^N lock combinations, and for each combination, we need to spend O(N^2) time traversing all digits and constructing the lock.  
    ***Space complexity*** is O(10^N * N + D) for the queue and deadset 
    <details>

      ```python
        def getNeighbours(self, s):
            result = []
            for i in range(len(s)):
                digit = int(s[i])
                for move in [-1, 1]:
                    nextDigit = (digit + move) % 10
                    result.append(s[:i] + str(nextDigit) + s[i + 1:])
            return result  
    
        def openLock(self, deadends: List[str], target: str) -> int:
            deadSet = set(deadends)     
            initialState = "0000"
            if initialState in deadSet:
                return -1
                
            visited = set([initialState])
            queue = deque([initialState])
            turns = 0
            while queue:
                levelSize = len(queue)
                for _ in range(levelSize):
                    node = queue.popleft()
                    if node == target:
                        return turns
                    
                    for neighbour in self.getNeighbours(node):
                        if neighbour in visited or neighbour in deadSet:
                            continue
    
                        visited.add(neighbour)
                        queue.append(neighbour)
                turns += 1
    
            return -1
      
      ```
    </details>
1. [127. Word Ladder](https://leetcode.com/problems/word-ladder)  
    Use chr to get the letter from its unicode  
    ***Time complexity*** O(N*(M^2)) where N is the number of words, M is the length of words. There are N words, and for each word, we need to spend O(M^2) time traversing all letters and constructing adjacent words.  
    ***Space complexity*** is O(N*M) for the queue to store all N words
    <details>

      ```python
        def getNextWords(self, word, wordSet):
            letterSize = 26
            result = []
            for i in range(len(word)):
                for j in range(letterSize):
                    letter = chr(j + ord("a"))
                    if letter != word[i]:
                        nextWord = word[:i] + letter + word[i + 1:]
                        if nextWord in wordSet:
                            result.append(nextWord)
            return result
    
        def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
            wordSet = set(wordList)
            queue = deque([beginWord])
            visited = set([beginWord])
            count = 0
            while queue:
                levelSize = len(queue)
                count += 1
                for _ in range(levelSize):
                    currWord = queue.popleft()
                    if currWord == endWord:
                        return count
    
                    for nextWord in self.getNextWords(currWord, wordSet):
                        if nextWord in visited:
                            continue
    
                        visited.add(nextWord)
                        queue.append(nextWord)
    
            return 0
      
      ```
    </details>
1.  [695. Max Area of Island](https://leetcode.com/problems/max-area-of-island)    
    Beware to change the cell value to 0 to mart it as visited when pushing root to queue, and also when pushing child elements to queue
    Time complexiy and space complexity is O(R * C) where R is number of rows, and C is number of columns
    <details>

      ```python
    def getArea(self, grid, row, col):
        queue = deque([(row, col)])
        area = 0
        grid[row][col] = 0
        directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]
        while queue:
            currRow, currCol = queue.popleft()
            area += 1
            
            for rowOffset, colOffset in directions:
                nextRow = currRow + rowOffset
                nextCol = currCol + colOffset
                if nextRow < 0 or nextRow >= len(grid) or nextCol < 0 or nextCol >= len(grid[0]) or grid[nextRow][nextCol] == 0:
                    continue
                grid[nextRow][nextCol] = 0
                queue.append((nextRow, nextCol))
        return area

    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        result = 0
        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if grid[r][c] == 1:
                    result = max(result, self.getArea(grid, r, c))

        return result
      ```
    </details>
1.  [542. 01 Matrix](https://leetcode.com/problems/01-matrix/)      
    Need to maintain a set for tracking visited nodes
    ***Initially only put 0 cells to queue as root***
    Time complexiy and space complexity is O(R * C) where R is number of rows, and C is number of columns
    <details>

      ```python
        def getArea(self, grid, row, col):
        def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
            visited = set()
            queue = deque()
            for r in range(len(mat)):
                for c in range(len(mat[0])):
                    if mat[r][c] == 0:
                        queue.append((r, c))
                        visited.add((r, c))
    
            directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]
            while queue:
                currRow, currCol = queue.popleft()
                for rowOffset, colOffset in directions:
                    nextRow = currRow + rowOffset
                    nextCol = currCol + colOffset
                    if nextRow < 0 or nextRow >= len(mat) or nextCol < 0 or nextCol >= len(mat[0]) or (nextRow, nextCol) in visited:
                        continue
                    
                    visited.add((nextRow, nextCol))
                    mat[nextRow][nextCol] = mat[currRow][currCol] + 1
                    queue.append((nextRow, nextCol))
            return mat
      ```
    </details>

1.  [994. Rotting Oranges](https://leetcode.com/problems/rotting-oranges)      
    Beware edge case when there is no fresh fruits, return 0 immediately, and also iniatially set elapsed minutes to -1  
    Time complexiy and space complexity is O(R * C) where R is number of rows, and C is number of columns  
    <details>

      ```python
        def orangesRotting(self, grid: List[List[int]]) -> int:
            queue = deque()
            fresh = 0
            for r in range(len(grid)):
                for c in range(len(grid[0])):
                    if grid[r][c] == 1:
                        fresh += 1
                    elif grid[r][c] == 2:
                        queue.append((r, c))
            if fresh == 0:
                return 0
    
            minutes = -1
            directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]
            while queue:
                levelSize = len(queue)
                minutes += 1
                for _ in range(levelSize):
                    row, col = queue.popleft()
    
                    for rowOffset, colOffset in directions:
                        nextRow = row + rowOffset
                        nextCol = col + colOffset
    
                        if 0 <= nextRow < len(grid) and 0 <= nextCol < len(grid[0]) and grid[nextRow][nextCol] == 1:
                            grid[nextRow][nextCol] = 2
                            fresh -= 1
                            queue.append((nextRow, nextCol))
                     
            return minutes if fresh == 0 else -1
      ```
    </details>
