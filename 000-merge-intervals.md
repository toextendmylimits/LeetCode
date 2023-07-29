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

1. [57. Insert Interval](https://leetcode.com/problems/insert-interval/)  
    1. Add non-overlapping intervals to result
    1. Merge new interval with overlapping intervals, and then add to result
    1. Add the remaining intervals to result
    Time complexity O(N), space complexity O(1)
    <details>

      ```python
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        merged = []
        i = 0
        size = len(intervals)
        while i < size and intervals[i][1] < newInterval[0]:
            merged.append(intervals[i])
            i += 1
        
        while i < size and intervals[i][0] <= newInterval[1]:
            newInterval[0] = min(newInterval[0], intervals[i][0])
            newInterval[1] = max(newInterval[1], intervals[i][1])
            i += 1
        merged.append(newInterval)

        while i < size:
            merged.append(intervals[i])
            i += 1

        return merged 
      ```
    </details>
https://leetcode.com/problems/meeting-rooms

https://leetcode.com/problems/meeting-rooms-ii

[Non overlapping intervals](https://leetcode.com/problems/non-overlapping-intervals) 
(Sort by ending time, pick the task that finishes earliest)

[Minimum Number of Arrows to Burst Balloons](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons) 
Sort by ending position, choose the needle at smalled ending position, then scan array, find next non-overlap range, increase count, and update ending position

[Car Pooling](https://leetcode.com/problems/car-pooling)
Line Sweeping, track the change of passengers at each stop
