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

1.  [347. Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements)
    <details>
      ```pyton
        def topKFrequent(self, nums: List[int], k: int) -> List[int]:
            counter = Counter(nums)
            minHeap = []
            for num, freq in counter.items():
                heappush(minHeap, (freq, num))
                if len(minHeap) > k:
                    heappop(minHeap)
    
            return [x[1] for x in minHeap]
      ```
    </details>
1.  [215. Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array)
    <details>
      ```pyton
        def findKthLargest(self, nums: List[int], k: int) -> int:
            minHeap = []
            for num in nums:
                heappush(minHeap, num)
                if len(minHeap) > k:
                    heappop(minHeap)
    
            return minHeap[0]     
      ```
    </details>
1.  [703. Kth Largest Element in a Stream](https://leetcode.com/problems/kth-largest-element-in-a-stream)  
   Time complexity O(N logK), space complexity O(K) where K is the size of the heap
    <details>
      ```pyton
        def __init__(self, k: int, nums: List[int]):
            self.heap = []
            self.heapSize = k
            for n in nums:
                heappush(self.heap, n)
                if len(self.heap) > self.heapSize:
                    heappop(self.heap)
    
        def add(self, val: int) -> int:
            heappush(self.heap, val)
            if len(self.heap) > self.heapSize:
                heappop(self.heap)
    
            return self.heap[0]  
      ```
    </details>
1.  [1167. Minimum Cost to Connect Sticks](https://leetcode.com/problems/minimum-cost-to-connect-sticks)  
   Time complexity is O(NlogN), space complexity O(N) as heap size is O(N), so push/pop O(N) times
    <details>
      ```pyton
        heapify(sticks)

        totalCost = 0
        while len(sticks) > 1:
            top2Sum = heappop(sticks) + heappop(sticks)
            totalCost += top2Sum
            heappush(sticks, top2Sum)

        return totalCost  
      ```
    </details>