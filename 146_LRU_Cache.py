I implement LRU Cache using two structures: a hash map and a doubly linked list.
The hash map gives O(1) access to nodes.
The linked list keeps keys ordered by recency—most recent at the head, least recent at the tail.
Whenever I get or update a key, I move its node to the head.
When inserting a new key and the cache is full, I evict the node at the tail, which is the least recently used.
This design guarantees O(1) get and put.

class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None


class LRUCache:

    def __init__(self, capacity):
        self.capacity = capacity
        self.cache = {}  # key -> Node

        # Dummy head and tail to avoid edge cases
        self.head = Node(-1, -1)
        self.tail = Node(-1, -1)
        self.head.next = self.tail
        self.tail.prev = self.head

    # -------------------------------------------------

    def get(self, key):
        if key not in self.cache:
            return -1

        node = self.cache[key]
        self._remove(node)
        self._add_to_front(node)
        return node.value

    # -------------------------------------------------

    def put(self, key, value):
        if key in self.cache:
            # Update existing node
            node = self.cache[key]
            node.value = value
            self._remove(node)
            self._add_to_front(node)
            return

        # Evict LRU if full
        if len(self.cache) == self.capacity:
            lru = self.tail.prev
            self._remove(lru)
            del self.cache[lru.key]

        # Insert new node at front
        new_node = Node(key, value)
        self._add_to_front(new_node)
        self.cache[key] = new_node

    # -------------------------------------------------

    def _remove(self, node):
        """Detach a node from the doubly linked list."""
        prev_node = node.prev
        next_node = node.next
        prev_node.next = next_node
        next_node.prev = prev_node

    def _add_to_front(self, node):
        """Insert a node right after head (most recent)."""
        first = self.head.next
        self.head.next = node
        node.prev = self.head
        node.next = first
        first.prev = node
