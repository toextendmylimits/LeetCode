I sort the intervals by start time. Then I scan through them and compare each interval with the last merged one. 
If they overlap, I extend the end boundary. 
If not, I add a new interval. This runs in O(n log n) because of sorting and O(n) for the merge.

class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        # Sort intervals by start time
        intervals.sort(key=lambda x: x[0])

        merged = [intervals[0]]

        for start, end in intervals[1:]:
            last_start, last_end = merged[-1]

            # If overlapping: extend the last interval
            if start <= last_end:
                merged[-1][1] = max(last_end, end)
            else:
                merged.append([start, end])
        
        return merged
