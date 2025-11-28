I use a list called values to store all elements, and a hash map index_map that maps each value to its index in the list.
Insert: append the element and record its index.
Remove: swap the element with the last element, update the map, then pop it.
GetRandom: choose a random element from values.
This makes insert, remove, and getRandom all O(1).

import random

class RandomizedSet:

    def __init__(self):
        self.values = []                   # list of stored elements
        self.index_map = {}                # value -> index in values

    def insert(self, value: int) -> bool:
        if value in self.index_map:
            return False

        self.index_map[value] = len(self.values)
        self.values.append(value)
        return True

    def remove(self, value: int) -> bool:
        if value not in self.index_map:
            return False

        remove_index = self.index_map[value]
        last_value = self.values[-1]

        # Move last element into the removed spot
        self.values[remove_index] = last_value
        self.index_map[last_value] = remove_index

        # Remove the old entry
        self.values.pop()
        del self.index_map[value]

        return True

    def getRandom(self) -> int:
        return random.choice(self.values)
