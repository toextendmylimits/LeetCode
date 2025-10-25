class Solution:
    def isIsomorphic(self, s1: str, s2: str) -> bool:
        if len(s1) != len(s2):
            return False
            
        letterFirstIdxS1 = {}
        letterFirstIdxS2 = {}
        for i in range(len(s1)):
            if (s1[i] in letterFirstIdxS1 and s2[i] not in letterFirstIdxS2) or (s1[i] not in letterFirstIdxS1
            and s2[i] in letterFirstIdxS2):
                return False
            elif s1[i] in letterFirstIdxS1 and s2[i] in letterFirstIdxS2:
                if letterFirstIdxS1[s1[i]] != letterFirstIdxS2[s2[i]]:
                    return False
            else:
                letterFirstIdxS1[s1[i]] = i
                letterFirstIdxS2[s2[i]] = i
        
        return True
