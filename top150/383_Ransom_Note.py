
from collections import Counter

class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        counterNote = Counter(ransomNote)
        counterMagazine = Counter(magazine)
        for letter in counterNote:
            if counterNote[letter] > counterMagazine[letter]:
                return False
        
        return True

solution = Solution()
print(solution.canConstruct('aa','aa'))
