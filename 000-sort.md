# Count Sorting
1. [274. H-Index](https://leetcode.com/problems/h-index/)  
<details>
    
    ```python
        def hIndex(self, citations: List[int]) -> int:
          count = [0] * (len(citations) + 1)
          for c in citations:
              if c > len(citations):
                  count[len(citations)] += 1
              else:
                  count[c] += 1
          
          total = 0
          for i in range(len(count) - 1, -1, -1):
              total += count[i]
              if total >= i:
                  return i
          
          return 0
    ```
</details>
