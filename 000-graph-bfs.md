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

1. [752. Open the Lock](https://leetcode.com/problems/open-the-lock)  
    ***Beware to check whether the initial state is in dead locks, and if so, return immediately.***  
    ***Time complexity*** O(10^N*(N^2) + D) where N is the number of digits, D is the nubmer of deadlocks. There are 10^N lock combinations, and for each combination, we need to spend O(N^2) time traversing all digits and constructing the lock.  
    ***Space complexity*** is O(10^N + D) for the queue and deadset 
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
    ***Space complexity*** is O(N*(M^2) for the queue to store all M transformations for each of the N words in the
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
    <details

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
