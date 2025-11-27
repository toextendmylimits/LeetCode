# I implement the stack as a doubly linked list, so I can push, pop, and
remove any specific node in O(1).

For tracking the maximum, I maintain a max-heap, where each entry stores
(-value, -sequenceId, nodePointer).

-value turns Python’s min-heap into a max-heap, and -sequenceId ensures
that among equal values, the most recently pushed element is chosen,
matching the “top-most max” requirement.

When a node is removed through the stack, I mark it as dead. The heap may
still contain stale entries, so peekMax and popMax lazily skip dead
nodes.

This gives O(1) top/pop and O(log n) push/popMax, satisfying the
constraints.
import heapq

class StackNode:
    def __init__(self, value):
        self.value = value
        self.prev = None
        self.next = None
        self.is_alive = True  # for lazy deletion


class MaxStack:

    def __init__(self):
        # doubly linked list (DLL) with dummy head/tail
        self.head = StackNode(0)
        self.tail = StackNode(0)
        self.head.next = self.tail
        self.tail.prev = self.head

        # max heap: stores (-value, -sequenceId, node)
        self.max_heap = []
        self.next_sequence_id = 0  # ensures top-most max is chosen

    # -------------------------
    # Doubly Linked List Helpers
    # -------------------------

    def _add_node_to_stack(self, node):
        """Insert node at the end of the doubly linked list (top of stack)."""
        last_real_node = self.tail.prev
        last_real_node.next = node
        node.prev = last_real_node
        node.next = self.tail
        self.tail.prev = node

    def _remove_node_from_stack(self, node):
        """Remove the node from the doubly linked list."""
        node.is_alive = False  # mark node deleted for lazy removal
        previous_node = node.prev
        next_node = node.next
        previous_node.next = next_node
        next_node.prev = previous_node

    # -------------------------
    # Core MaxStack Operations
    # -------------------------

    def push(self, value: int) -> None:
        node = StackNode(value)

        # add to DLL
        self._add_node_to_stack(node)

        # add to max-heap
        heapq.heappush(
            self.max_heap,
            (-value, -self.next_sequence_id, node)
        )
        self.next_sequence_id += 1

    def top(self) -> int:
        return self.tail.prev.value

    def pop(self) -> int:
        node = self.tail.prev
        self._remove_node_from_stack(node)
        return node.value

    def _clean_heap_top(self):
        """Remove dead nodes from the top of the heap."""
        while self.max_heap and not self.max_heap[0][2].is_alive:
            heapq.heappop(self.max_heap)

    def peekMax(self) -> int:
        self._clean_heap_top()
        return -self.max_heap[0][0]

    def popMax(self) -> int:
        self._clean_heap_top()

        neg_value, neg_sequence_id, node = heapq.heappop(self.max_heap)
        self._remove_node_from_stack(node)
        return -neg_value
