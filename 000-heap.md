# Heap
1.  [973. K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin)
    Use max heap Time complexity O(NlogK), space complexity is O(K)
    If use min heap, time complexity O(KlogN + N), space complexity is O(N)
    <details>
      ```pyton
      def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
          maxHeap = []
          for point in points:
              distance = point[0] ** 2 + point[1] ** 2
              heappush(maxHeap, (-distance, point))
              if len(maxHeap) > k:
                  heappop(maxHeap)
          
          return [x[1] for x in maxHeap]
      ```
    </details>
