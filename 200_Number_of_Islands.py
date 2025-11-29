# DFS

You scan the grid.
Every time you find a '1' that has not been visited, that means you found a new island.
Then you flood-fill (DFS/BFS) to mark the entire island as visited so you don’t count it again.
Count how many times this happens.

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        rows, cols = len(grid), len(grid[0])
        islands = 0

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == "1":
                    islands += 1
                    self.dfs(grid, r, c, rows, cols)

        return islands
    
    def dfs(self, grid, r, c, rows, cols):
        if r < 0 or r >= rows or c < 0 or c >= cols or grid[r][c] != "1":
            return
        
        grid[r][c] = "0"  # mark visited
        
        # explore 4 neighbors
        for dr, dc in [(-1,0), (0,1), (1,0), (0,-1)]:
            self.dfs(grid, r + dr, c + dc, rows, cols)

# BFS 

from collections import deque

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        rows, cols = len(grid), len(grid[0])
        count = 0
        
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == "1":
                    count += 1
                    self.bfs(grid, r, c, rows, cols)
        
        return count

    def bfs(self, grid, r, c, rows, cols):
        queue = deque([(r, c)])
        grid[r][c] = "0"  # mark visited
        
        while queue:
            x, y = queue.popleft()
            
            for dx, dy in [(-1,0), (0,1), (1,0), (0,-1)]:
                nx, ny = x + dx, y + dy
                
                if 0 <= nx < rows and 0 <= ny < cols and grid[nx][ny] == "1":
                    grid[nx][ny] = "0"
                    queue.append((nx, ny))
