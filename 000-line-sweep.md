# Line Sweep
1. [759. Employee Free Time](https://leetcode.com/problems/employee-free-time)  
    
    Find the number of employees working along the timeline, and if at any time, the number is 0, then it's the starting time of a free time interval, and the ending time for this free time interval is the next time that the number is not 0  
    Time complexity O(N logN), space complexity O(N)
    <details>
        
        ```python
           def employeeFreeTime(self, schedule: '[[Interval]]') -> '[Interval]':
              counter = Counter()
              for intervals in schedule:
                  for interval in intervals:
                      counter[interval.start] += 1
                      counter[interval.end] -= 1
      
              startTime = -1
              workingCount = 0
              result = []
              for time, deltaCount in sorted(counter.items()):
                  workingCount += deltaCount
                  if workingCount == 0:
                      startTime = time
                  elif startTime != -1:
                      result.append(Interval(startTime, time))
                      startTime = -1
              return result     
        ```
    </details>
