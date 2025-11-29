I use a divide-and-conquer approach similar to merge sort.
I recursively split the k linked lists into two halves, merge each half, 
and then merge the results. Each merge operation is linear, and 
each level of recursion reduces k by half, so the total time complexity is O(N log k).

This is optimal and avoids storing k nodes in a heap. 
It also makes the merging process more cache-friendly and produces very readable code.

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        return self._merge_range(lists, 0, len(lists) - 1)
    
    def _merge_range(self, lists, start, end):
        if start > end:
            return None
        if start == end:
            return lists[start]
        
        mid = (start + end) // 2
        left_merged = self._merge_range(lists, start, mid)
        right_merged = self._merge_range(lists, mid + 1, end)
        return self._merge_two_lists(left_merged, right_merged)
    
    def _merge_two_lists(self, list1, list2):
        dummy_head = ListNode()
        prev = dummy_head
        while list1 and list2:
            if list1.val < list2.val:
                prev.next = list1
                list1 = list1.next
            else:
                prev.next = list2
                list2 = list2.next
            prev = prev.next

        prev.next = list1 or list2
        return dummy_head.next
