# Graph DFS
1.  [733. Flood Fill](https://leetcode.com/problems/flood-fill)  
    Beware the edge case when original color is same with replacement color, as it leads to infinite stack call, so should return image immediately if original color is same as replacement color
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
  
