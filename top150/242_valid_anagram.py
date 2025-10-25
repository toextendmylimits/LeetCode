from collections import Counter

class Solution:
    def isValidAnagram(self,s1,s2):
        if len(s1) != len(s2):
            return False
        
        counterS1 = Counter(s1)
        counterS2 = Counter(s2)
        for letter, freq in counterS1.items():
            if freq != counterS2[letter]:
                return False
        
        return True

solution = Solution()   
print(solution.isValidAnagram("aab","aba"))
print(solution.isValidAnagram("aab","abaa"))
