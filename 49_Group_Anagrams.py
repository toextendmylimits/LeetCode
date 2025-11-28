# Approach 1: Sort 
I create a dictionary where the key is the sorted version of the string, and the value is a list of all strings that share that key.
Two strings are anagrams if their sorted characters match.
So I sort each string, use it as the key, and append the string into the corresponding bucket.
The runtime is O(n · k log k).

from collections import defaultdict

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        groups = defaultdict(list)

        for s in strs:
            key = self._sorted_key(s)
            groups[key].append(s)

        return list(groups.values())

    def _sorted_key(self, s: str) -> str:
        return "".join(sorted(s))

# Approach 2
This solution uses a frequency signature instead of sorting each string.
For every word, I count how often each of the 26 letters appears.
This 26-length tuple is a unique signature for all anagrams.
I use it as a hash map key and group words accordingly.
This avoids sorting and gives O(n·k) time instead of O(n·k log k)

from collections import defaultdict
from typing import List

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagram_groups = defaultdict(list)

        for word in strs:
            key = self._build_char_count_key(word)
            anagram_groups[key].append(word)

        return list(anagram_groups.values())

    def _build_char_count_key(self, word: str) -> tuple:
        """
        Build a 26-length frequency key for the word.
        Example: "eat" -> (1,0,0,0,1,0,0,...0,1)
        Using tuple so it’s hashable and usable as dict key.
        """
        char_count = [0] * 26
        for char in word:
            char_count[ord(char) - ord('a')] += 1
        
        return tuple(char_count)
