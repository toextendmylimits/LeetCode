# Method 1: slow fast pointer
class Solution:
    def isHappy(self, n: int) -> bool:
        slow = self.getNext(n)
        fast = self.getNext(slow)
        while fast != slow:
            slow = self.getNext(slow)
            fast = self.getNext(self.getNext(fast))
        
        return fast == 1
    
    def getNext(self, n):
        total = 0
        while n != 0:
            lastDigit = n % 10
            total += lastDigit * lastDigit
            n //= 10
        return total


# Method 2: Use hash map
class Solution:
    def isHappy(self, n: int) -> bool:
        seen = set()
        while n not in seen:
            seen.add(n)
            n = self.getNext(n)
        
        return n == 1
    
    def getNext(self, n):
        total = 0
        while n != 0:
            lastDigit = n % 10
            total += lastDigit * lastDigit
            n //= 10
        return total
