Each digit maps to letters. I use backtracking: starting from the first digit, 
I try every mapped letter, append it to the current string, recurse to the next digit, 
and when I reach the end, I add the built string to the result. 
If the input is empty, I return an empty list.

from typing import List

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []

        digit_to_letters = {
            "2": "abc", "3": "def", "4": "ghi", "5": "jkl",
            "6": "mno", "7": "pqrs", "8": "tuv", "9": "wxyz",
        }

        result = []
        path = []

        def backtrack(i: int) -> None:
            if i == len(digits):
                result.append("".join(path))
                return

            letters = digit_to_letters[digits[i]]
            for ch in letters:
                path.append(ch)
                backtrack(i + 1)
                path.pop()

        backtrack(0)
        return result
