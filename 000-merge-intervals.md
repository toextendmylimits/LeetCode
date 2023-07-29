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
1. [986. Interval List Intersections](https://leetcode.com/problems/interval-list-intersections)  
    ***Importantly the elements in each list are disjointed***  
    The idea is compare the front element of the two lists, and then discard the element with smaller end point
    Use two pointers, one for each list  
    1. If element of first List and element of second list overlap, add the overlap to result
    1. If element of first list's end point is smaller than second list's point, move first list's pointer to the next; Otherwise, move second list's pointer to next

    Time complexity O(N), space complexity O(1)
    <details>

      ```python
        def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:
            result = []
            i = 0
            j = 0
            while i < len(firstList) and j < len(secondList):
                first = firstList[i]
                second = secondList[j]
                if first[0] <= second[1] and second[0] <= first[1]:
                    result.append([max(first[0], second[0]), min(first[1], second[1])])   
                if first[1] < second[1]:
                    i += 1
                else:
                    j += 1
            return result
      ```
    </details>
1. [759. Employee Free Time](https://leetcode.com/problems/employee-free-time)  
    Sort all intervals by start time, then check whether ther is non-overlapping time interval
    Time complexity O(N logN), space complexity O(N)
    <details>
        
        ```python
        def employeeFreeTime(self, schedule: '[[Interval]]') -> '[Interval]':
            if not schedule:
                return []
            
            intervals = []
            result = []
            for employee in schedule:
                for interval in employee:
                    intervals.append((interval.start, interval.end))
    
            intervals.sort()
            lastEnd = intervals[0][1]
            for i in range(1, len(intervals)):
                currStart, currEnd = intervals[i]
                if currStart > lastEnd:
                    result.append(Interval(lastEnd, currStart))
                lastEnd = max(lastEnd, currEnd)
    
            return result  
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
