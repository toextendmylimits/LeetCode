class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        last_position_word1 = -1
        last_position_word2 = -1
        minimum_distance = float('inf')

        for index, word in enumerate(wordsDict):
            # Update the most recent seen position of each word
            if word == word1:
                last_position_word1 = index
            elif word == word2:
                last_position_word2 = index

            # If both words have been seen, update the minimum distance
            if last_position_word1 != -1 and last_position_word2 != -1:
                minimum_distance = min(
                    minimum_distance,
                    abs(last_position_word1 - last_position_word2)
                )

        return minimum_distance
