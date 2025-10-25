from typing import List # Needed for List in method signature, but not needed for interview because no need to specify List in signature
from collections import defaultdict, Counter

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        hashStrsMap = defaultdict(list)
        for s in strs:
            hashStrsMap[self.getHash(s)].append(s)
        
        result = []
        for hashValue, strs in hashStrsMap.items():
            result.append([s for s in strs])
        return result
    
    def getHash(self, s):
        counter = Counter(s)
        result = []
        for letter in "abcdefghijklmnopqrstuvwxyz":
            if counter[letter] > 0:
                result.append(letter + str(counter[letter]) + ",")
        return "".join(result)

solution = Solution()
print(solution.groupAnagrams(["eat","tea","tan","ate","nat","bat"]))
