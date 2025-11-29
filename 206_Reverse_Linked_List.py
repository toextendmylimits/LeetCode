# Iterative

Use three pointers: curr, prev, and next_node.
We iterate through the list, and for each node we temporarily store curr.next, then flip the pointer so curr.next = prev.
Then we shift both prev and curr forward.
At the end, prev points to the new head.
Time complexity is O(n), space is O(1).

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prev = None
        curr = head

        while curr:
            next_node = curr.next   # temporarily store next
            curr.next = prev        # reverse the pointer
            prev = curr             # move prev forward
            curr = next_node        # move curr forward

        return prev

