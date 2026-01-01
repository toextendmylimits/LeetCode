To minimize removals, I maximize the number of non-overlapping intervals.
A greedy strategy works: sort by end time and always keep the interval that ends earliest.

class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x : x[1])
        prev_end = intervals[0][1]
        removed = 0
        for start, end in intervals[1:]:
            if start < prev_end:
                removed += 1
            else:
                prev_end = end
        
        return removed

