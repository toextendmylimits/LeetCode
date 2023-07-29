# Merge Intervals

1.  [Merge Intervals](https://leetcode.com/problems/merge-intervals/)  
    Time complexity O(N logN), space complexity O(log N) or O(N) depends on the sorting algorithm
    <details>

      ```python
      def merge(self, intervals: List[List[int]]) -> List[List[int]]:
          intervals.sort()
          merged = []
          for interval in intervals:
              # No overlap
              if not merged or interval[0] > merged[-1][1]:
                  merged.append(interval)
              else:
                  merged[-1][1] = max(merged[-1][1], interval[1])
          
          return merged      
      ```
    </details>

https://leetcode.com/problems/insert-interval/

https://leetcode.com/problems/meeting-rooms

https://leetcode.com/problems/meeting-rooms-ii

[Non overlapping intervals](https://leetcode.com/problems/non-overlapping-intervals) 
(Sort by ending time, pick the task that finishes earliest)

[Minimum Number of Arrows to Burst Balloons](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons) 
Sort by ending position, choose the needle at smalled ending position, then scan array, find next non-overlap range, increase count, and update ending position

[Car Pooling](https://leetcode.com/problems/car-pooling)
Line Sweeping, track the change of passengers at each stop
