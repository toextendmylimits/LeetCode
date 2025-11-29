# Approach 1: Sweeping Line
I treat each meeting start as +1 room needed and each meeting end as -1 room.
I sort all time points and sweep through them while keeping a running count of active meetings.
The maximum active count is the number of rooms required.

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        room_change_at_time = Counter()

        # +1 when a meeting starts, -1 when a meeting ends
        for start, end in intervals:
            room_change_at_time[start] += 1
            room_change_at_time[end] -= 1

        active_rooms = 0
        max_rooms = 0

        # Sweep through time
        for time in sorted(room_change_at_time):
            active_rooms += room_change_at_time[time]
            max_rooms = max(max_rooms, active_rooms)

        return max_rooms

# Approach 2: Heap
I sort the meetings by start time, then use a min-heap to track end times of meetings currently using rooms.
For each meeting, I check the earliest ending one in the heap.
If it ends before the new meeting starts, I reuse that room and pop it.
Otherwise, I need a new room and leave the heap as is.
Then I push the new meeting’s end time.
The heap size at any moment equals how many rooms are in use, and the maximum size the heap reaches is the number of rooms needed.
This runs in O(N log N).
  
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if not intervals:
            return 0
        
        intervals.sort(key=lambda x: x[0])
        
        import heapq
        min_heap = []
        
        for start, end in intervals:
            if min_heap and min_heap[0] <= start:
                heapq.heappop(min_heap)
            
            heapq.heappush(min_heap, end)
        
        return len(min_heap)
