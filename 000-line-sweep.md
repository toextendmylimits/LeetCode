# Line Sweep
1. [759. Employee Free Time](https://leetcode.com/problems/employee-free-time)  
    
    List the number of employees working in the order of time, and if at any time, the number is 0, then it's the starting time of a free time interval, and the ending time for this free time interval is the next time that the number is not 0  
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
1. [253. Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii)  
    Use hash map, key is time, and value is the change of meeting rooms  
    Sort the items of the map by time. At any time, find the meeting rooms required, and update the result if this is larger than the result  
    <details>
        
        ```python
        def minMeetingRooms(self, intervals: List[List[int]]) -> int:
            timeRoomDeltaMap = Counter()
            for interval in intervals:
                timeRoomDeltaMap[interval[0]] += 1
                timeRoomDeltaMap[interval[1]] -= 1
            
            result = 0
            currRooms = 0
            for time, roomDelta in sorted(timeRoomDeltaMap.items()):
                currRooms += roomDelta
                result = max(result, currRooms)
    
            return result   
        ```
    </details>
