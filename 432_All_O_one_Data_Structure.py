class Bucket:
    def __init__(self, count):
        self.count = count          # frequency / count value
        self.keys = set()           # all keys with this count
        self.prev = None
        self.next = None


class AllOne:
    def __init__(self):
        self.keyToBucket = {}       # key -> bucket that contains it

        # sentinel boundaries (never store real keys)
        self.head = Bucket(0)       # smallest side
        self.tail = Bucket(0)       # largest side
        self.head.next = self.tail
        self.tail.prev = self.head


    # Insert newBucket between prevBucket and nextBucket
    def _insertBucket(self, prevBucket, nextBucket, newBucket):
        prevBucket.next = newBucket
        newBucket.prev = prevBucket
        newBucket.next = nextBucket
        nextBucket.prev = newBucket


    # Remove a bucket from the list
    def _removeBucket(self, bucket):
        bucket.prev.next = bucket.next
        bucket.next.prev = bucket.prev


    # --------------------------------------------------------
    # Increase count of key by 1
    # --------------------------------------------------------
    def inc(self, key: str) -> None:
        # Case 1: new key — it belongs in the count=1 bucket
        if key not in self.keyToBucket:
            # Ensure bucket for count=1 exists
            if self.head.next.count != 1:
                newBucket = Bucket(1)
                self._insertBucket(self.head, self.head.next, newBucket)
            bucket1 = self.head.next

            bucket1.keys.add(key)
            self.keyToBucket[key] = bucket1
            return

        # Case 2: existing key — move it one bucket to the right
        currentBucket = self.keyToBucket[key]
        currentBucket.keys.remove(key)
        currentCount = currentBucket.count

        # Ensure bucket for (count+1) exists
        if currentBucket.next.count != currentCount + 1:
            newBucket = Bucket(currentCount + 1)
            self._insertBucket(currentBucket, currentBucket.next, newBucket)
        nextBucket = currentBucket.next

        nextBucket.keys.add(key)
        self.keyToBucket[key] = nextBucket

        # Remove empty bucket
        if not currentBucket.keys:
            self._removeBucket(currentBucket)


    # --------------------------------------------------------
    # Decrease count of key by 1
    # --------------------------------------------------------
    def dec(self, key: str) -> None:
        currentBucket = self.keyToBucket[key]
        currentBucket.keys.remove(key)
        currentCount = currentBucket.count

        # If count becomes 0, remove key entirely
        if currentCount == 1:
            del self.keyToBucket[key]
        else:
            # Ensure bucket for (count-1) exists
            if currentBucket.prev.count != currentCount - 1:
                newBucket = Bucket(currentCount - 1)
                self._insertBucket(currentBucket.prev, currentBucket, newBucket)
            prevBucket = currentBucket.prev

            prevBucket.keys.add(key)
            self.keyToBucket[key] = prevBucket

        # Remove empty bucket
        if not currentBucket.keys:
            self._removeBucket(currentBucket)


    # --------------------------------------------------------
    # Return any key with maximum count
    # --------------------------------------------------------
    def getMaxKey(self) -> str:
        return "" if self.tail.prev == self.head else next(iter(self.tail.prev.keys))


    # --------------------------------------------------------
    # Return any key with minimum count
    # --------------------------------------------------------
    def getMinKey(self) -> str:
        return "" if self.head.next == self.tail else next(iter(self.head.next.keys))

# Easy to memorize version
class Bucket:
    def __init__(self, c):
        self.count = c
        self.keys = set()
        self.prev = self.next = None

class AllOne:
    def __init__(self):
        self.head, self.tail = Bucket(0), Bucket(0)
        self.head.next, self.tail.prev = self.tail, self.head
        self.pos = {}  # key -> Bucket

    def _insert_after(self, node, nb):
        nb.prev, nb.next = node, node.next
        node.next.prev = nb
        node.next = nb

    def _remove_bucket_if_empty(self, b):
        if b is self.head or b is self.tail or b.keys:
            return
        b.prev.next = b.next
        b.next.prev = b.prev

    def _next_bucket(self, b, target):
        n = b.next
        if n is self.tail or n.count != target:
            nb = Bucket(target)
            self._insert_after(b, nb)
            return nb
        return n

    def _prev_bucket(self, b, target):
        p = b.prev
        if p is self.head or p.count != target:
            nb = Bucket(target)
            self._insert_after(p, nb)   # insert between p and b
            return nb
        return p

    def inc(self, key: str) -> None:
        if key not in self.pos:
            b1 = self._next_bucket(self.head, 1)
            b1.keys.add(key)
            self.pos[key] = b1
            return

        cur = self.pos[key]
        nxt = self._next_bucket(cur, cur.count + 1)
        cur.keys.remove(key)
        nxt.keys.add(key)
        self.pos[key] = nxt
        self._remove_bucket_if_empty(cur)

    def dec(self, key: str) -> None:
        if key not in self.pos:
            return

        cur = self.pos[key]
        if cur.count == 1:
            cur.keys.remove(key)
            del self.pos[key]
            self._remove_bucket_if_empty(cur)
            return

        prv = self._prev_bucket(cur, cur.count - 1)
        cur.keys.remove(key)
        prv.keys.add(key)
        self.pos[key] = prv
        self._remove_bucket_if_empty(cur)

    def getMaxKey(self) -> str:
        return "" if self.tail.prev is self.head else next(iter(self.tail.prev.keys))

    def getMinKey(self) -> str:
        return "" if self.head.next is self.tail else next(iter(self.head.next.keys))
