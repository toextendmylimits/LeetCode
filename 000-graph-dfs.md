# Graph DFS
1.  [733. Flood Fill](https://leetcode.com/problems/flood-fill)  
    Beware the edge case when original color is same with replacement color, as it leads to infinite recursive stack call, so should return image immediately if original color is same as replacement color
    <details

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
  
1.  [695. Max Area of Island](https://leetcode.com/problems/max-area-of-island)    
    The dfs method should return the area  
    Time complexiy and space complexity is O(R * C) where R is number of rows, and C is number of columns
    <details

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
1.  [133. Clone Graph(https://leetcode.com/problems/clone-graph)    
    Clone the nodes recruisively  
    Need hash map to map new node to cloned node, so when a node is cloned already, next time we can just reference its cloned value
    ***Time complexiy*** is Time Complexity: O(V+E), where V is a number of nodes (vertices) and E is a number of edges.  
    ***Space complexity*** is O(V). This space is occupied by the  hash map and in addition to that, space would also be occupied by the recursion stack O(H) where H is the height of the graph.
    <details

      ```python
        def cloneGraph(self, node: 'Node') -> 'Node':
            oldToNewMap = {}
            def clone(node):
                if node in oldToNewMap:
                    return oldToNewMap[node]
    
                copy = Node(node.val)
                oldToNewMap[node] = copy
                for nei in node.neighbors:
                    copy.neighbors.append(clone(nei))
                return copy
                
            return clone(node) if node else None
      ```
    </details>
