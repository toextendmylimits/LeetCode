class Solution:
    def isCelebrity(self, n, candidate):
        for j in range(n):
            if j == candidate:
                continue
            # candidate must know nobody, and everyone must know candidate
            if knows(candidate, j) or not knows(j, candidate):
                return False
        return True
    
    def findCelebrity(self, n):
        candidate = 0
        # Correct logic: candidate eliminated if they know i
        for i in range(1, n):
            if knows(candidate, i):
                candidate = i
        
        if self.isCelebrity(n, candidate):
            return candidate
        return -1
