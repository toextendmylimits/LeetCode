from collections import defaultdict

class WordDistance:

    def __init__(self, wordsDict: List[str]):
        # Map each word to all its positions in wordsDict
        self.word_positions = defaultdict(list)
        
        for index, word in enumerate(wordsDict):
            self.word_positions[word].append(index)

    def shortest(self, word1: str, word2: str) -> int:
        # Sorted positions of each word in the original array
        positions1 = self.word_positions[word1]
        positions2 = self.word_positions[word2]

        i = j = 0
        min_distance = float('inf')

        # Two-pointer sweep
        while i < len(positions1) and j < len(positions2):
            idx1, idx2 = positions1[i], positions2[j]
            min_distance = min(min_distance, abs(idx1 - idx2))

            # Move the pointer pointing to the smaller index
            if idx1 < idx2:
                i += 1
            else:
                j += 1

        return min_distance
