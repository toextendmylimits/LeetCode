class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        previous_position_word1 = -1
        previous_position_word2 = -1
        minimum_distance = float('inf')
        are_same_word = (word1 == word2)

        for index, word in enumerate(wordsDict):

            if are_same_word:
                # handle same-word case
                if word == word1:
                    if previous_position_word1 != -1:
                        minimum_distance = min(minimum_distance,
                                               index - previous_position_word1)
                    previous_position_word1 = index

            else:
                # handle different-word case
                if word == word1:
                    previous_position_word1 = index
                elif word == word2:
                    previous_position_word2 = index

                if previous_position_word1 != -1 and previous_position_word2 != -1:
                    minimum_distance = min(
                        minimum_distance,
                        abs(previous_position_word1 - previous_position_word2)
                    )

        return minimum_distance
