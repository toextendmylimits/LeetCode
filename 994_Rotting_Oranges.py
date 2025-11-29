
We treat all initially rotten oranges as the starting points of a multi-source BFS. 
Each BFS level represents one minute. For every rotten orange in the queue, we try its four neighbors; 
if a neighbor is fresh, we rot it and add it to the queue.
We track the number of fresh oranges and reduce it whenever one rots. 
After BFS finishes, if any fresh orange remains, the answer is –1; 
otherwise the number of BFS layers is the answer. This ensures we compute the minimum number of minutes.”

from collections import deque

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        rows, cols = len(grid), len(grid[0])
        fresh_count = 0
        queue = deque()

        # Count fresh oranges + enqueue all rotten ones
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 1:
                    fresh_count += 1
                elif grid[r][c] == 2:
                    queue.append((r, c))

        if fresh_count == 0:
            return 0

        time = -1
        directions = [(-1,0),(0,1),(1,0),(0,-1)]

        while queue:
            for _ in range(len(queue)):
                curr_row, curr_col = queue.popleft()

                for dr, dc in directions:
                    nr, nc = curr_row + dr, curr_col + dc
                    if not (0 <= nr < rows and 0 <= nc < cols and grid[nr][nc] == 1):
                        continue

                    grid[nr][nc] = 2
                    fresh_count -= 1
                    queue.append((nr, nc))

            time += 1

        return time if fresh_count == 0 else -1
