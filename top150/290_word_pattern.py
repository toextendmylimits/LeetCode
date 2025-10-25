    words = s.split()
    if len(pattern) != len(words):
        return False
    
    letterFirstIdxMap = {}
    wordFirstIdxMap = {}
    for i in range(len(pattern)):
        print(i,letterFirstIdxMap,wordFirstIdxMap)
        if (pattern[i] in letterFirstIdxMap and words[i] not in wordFirstIdxMap) or (pattern[i] not in 
        letterFirstIdxMap and words[i] in wordFirstIdxMap):
            return False
        elif pattern[i] in letterFirstIdxMap and words[i] in wordFirstIdxMap:
            if letterFirstIdxMap[pattern[i]] != wordFirstIdxMap[words[i]]:
                return False
        else:
            letterFirstIdxMap[pattern[i]] = i
            wordFirstIdxMap[words[i]] = i
            
    return True
