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
