# Heap
I count each element’s frequency, then maintain a min-heap of size k storing (frequency, value).
If the heap grows beyond k, I pop the smallest frequency.
This ensures the heap always contains the k most frequent elements.
Time complexity is O(n log k), which is faster than sorting when k is small.

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq_map = Counter(nums)
        min_heap = []

        for num, freq in freq_map.items():
            heapq.heappush(min_heap, (freq, num))
            if len(min_heap) > k:
                heapq.heappop(min_heap)   # remove smallest frequency
        
        return [num for freq, num in min_heap]
