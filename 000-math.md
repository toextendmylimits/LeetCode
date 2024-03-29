# Math
1. [233. Number of Digit One](https://leetcode.com/problems/number-of-digit-one)  
  The idea is to calculate occurrence of 1 on every digit. There are 3 scenarios, for example, if n = xyzdabc  
   1. xyz * 1000                     if d == 0
   1. xyz * 1000 + abc + 1           if d == 1
   1. xyz * 1000 + 1000              if d > 1
    <details>
    
    ```python
    def countDigitOne(self, n: int) -> int:
        if n <= 0:
            return 0
        
        count = 0
        quotient = n
        divisor = 1
        while quotient > 0:
            digit = quotient % 10
            quotient //= 10
            count += quotient * divisor
            if digit == 1:
                count += n % divisor + 1
            elif digit > 1:
                count += divisor
            divisor *= 10
        
        return count
    ```
   </details>   
1. [670. Maximum Swap](https://leetcode.com/problems/maximum-swap)  
   Basic idea:
   1. Find a index i, where there is a increasing order. If there is no such i, then swap is not possible, return straight away  
   1. On the right side of i, find the max value (max_val) and its index (max_idx)
   1. On the left side of i, find the most left value and its index (left_idx), which is less than max_val
   1. Swap above left_idx and max_idx if necessary
    <details>
    
    ```python
       def maximumSwap(self, num: int) -> int:
           digits = list(str(num))
   
           couldSwap = False
           for i in range(len(digits) - 1):
               if digits[i] < digits[i + 1]:
                   couldSwap = True
                   break
                   
           if not couldSwap:
               return num 
           
           rightIdx = i + 1
           for j in range(rightIdx + 1, len(digits), 1):
               if digits[j] >= digits[rightIdx]:
                   rightIdx = j
   
           leftIdx = i
           for k in range(leftIdx):
               if digits[k] < digits[rightIdx]:
                   leftIdx = k
                   break
   
           digits[leftIdx], digits[rightIdx] = digits[rightIdx], digits[leftIdx]
           return int("".join(digits))
    ```
   </details>


1. [204. Count Primes](https://leetcode.com/problems/count-primes)  
   Use array isPrime to represent whether number at index is a prime   
   i from 2 to not exceeding sqrt(n)  
   j from i * i to not exceeding n  
   ***Time complexity*** O(sqrt(n) * log logN + N)  
   ***Space complexity*** O(N)
   <details>
    
    ```python
      def countPrimes(self, n: int) -> int:
          if n < 2:
              return 0
  
          isPrime = [False, False] + [True] * (n - 2)
          for i in range(2, int(sqrt(n)) + 1):
              if isPrime[i]:
                  for j in range(i * i, n, i):
                      isPrime[j] = False
          
          return sum(isPrime)
    ```
   </details>

1. [12. Integer to Roman](https://leetcode.com/problems/integer-to-roman)   
   Create a hash map for the 13 symbols, key is value, and value is symbol. Iterate through the map, in each iteration if value is less than num, divide num by value to get count, append the symbol of count times, and set num to remainder; If num is 0, break
  ***Time complexity*** O(1)  
   ***Space complexity*** O(1)
   <details>
    
    ```python
    def intToRoman(self, num: int) -> str:
        valueSymbolMap = [(1000, "M"), (900, "CM"), (500, "D"), (400, "CD"), (100, "C"), 
                  (90, "XC"), (50, "L"), (40, "XL"), (10, "X"), (9, "IX"), 
                  (5, "V"), (4, "IV"), (1, "I")]
        
        result = []

        for value, symbol in valueSymbolMap:
            if value <= num:
                count, num = divmod(num, value)
                result.append(symbol * count)
            
            if num == 0:
                break

        return "".join(result)
    ```
   </details>

1. [202. Happy Number](https://leetcode.com/problems/happy-number)   
   There are 2 parts to the algorithm we'll need to design and code.  
   1. Given a number n, what is its next number?  
   1. Follow a chain of numbers and detect if we've entered a cycle. This can be done either using hash table for fast/slow pointer   
   ***Approach 1 - hash table***
   Time complexity: O(logN + log logN ...) = O(logN), space complexity similarly is also O(logN)
   <details>
    
    ```python
       def isHappy(self, n: int) -> bool:
           def getNext(n):
               total = 0
               while n != 0:
                  digit = n % 10
                  total += digit * digit
                  n //= 10
   
               return total 
           
           seen = set()
           while n != 1 and n not in seen:
               seen.add(n)
               n = getNext(n)
           
           return n == 1
    ```
   </details>

   ***Approach 2 - fast/slow pointer***
   Time complexity: O(logN + log logN ...) = O(logN), space complexity similarly is also O(1)
   <details>
    
    ```python
        slow = n
        fast = getNext(n)
        while fast != 1 and fast != slow:
            slow = getNext(slow)
            fast = getNext(getNext(fast))
        return fast == 1
    ```
   </details>

1. [172. Factorial Trailing Zeroes](https://leetcode.com/problems/factorial-trailing-zeroes)            
   ***Approach 1 - Calculate factorial first and then counter trailing zeroes***  
   Time complexity: O(N), space complexity O(1)
   <details>
    
    ```python
       def trailingZeroes(self, n: int) -> int:
           factor = 1
           for i in range(2, n + 1):
               factor *= i
           
           count = 0
           while factor % 10 == 0:
               count += 1               
               factor //= 10
   
           return count
    ```
   </details>

   ***Approach 2 - Counting factor of 5***  
   [Good solution source](https://leetcode.com/problems/factorial-trailing-zeroes/solutions/52470/4-lines-4ms-c-solution-with-explanations/)   
   Well, to compute the number of trailing zeros, we need to first think clear about what will generate a trailing 0? Obviously, a number multiplied by 10 will have a trailing 0 added to it. So we only need to find out how many 10's will appear in the expression of the factorial. Since 10 = 2 * 5 and there are a bunch more 2's (each even number will contribute at least one 2), we only need to count the number of 5's.  

   Now let's see what numbers will contribute a 5. Well, simply the multiples of 5, like 5, 10, 15, 20, 25, 35, .... So is the result simply n / 5? Well, not that easy. Notice that some numbers may contribute more than one 5, like 25 = 5 * 5. Well, what numbers will contribute more than one 5? Ok, you may notice that only multiples of the power of 5 will contribute more than one 5. For example, multiples of 25 will contribute at least two 5's.  

   Well, how to count them all? If you try some examples, you may finally get the result, which is n / 5 + n / 25 + n / 125 + .... The idea behind this expression is: all the multiples of 5 will contribute one 5, the multiples of 25 will contribute one more 5 and the multiples of 125 will contribute another one more 5... and so on. Now, we can write down the following code, which is pretty short.  
   <details>
    
    ```python
       def trailingZeroes(self, n: int) -> int:
           count = 0
           while n != 0:
               n //= 5
               count += n
           return count
    ```
   </details>

1. [50. Pow(x, n)](https://leetcode.com/problems/powx-n)           
   ***Approach 1 - Recursive***  
   Calculate power of x * x to n // 2  
   <details>
    
    ```python
       def myPow(self, x: float, n: int) -> float:
           if n < 0:
               return 1 / self.myPow(x, -n)
           if n == 0:
               return 1
   
           pow = self.myPow(x * x, n // 2)
           return pow if n % 2 == 0 else x * pow
    ```
   </details>

   ***Approach 2 - Iterative***  

   <details>
    
    ```python
       def myPow(self, x: float, n: int) -> float:
           if n < 0:
               return 1 / self.myPow(x, -n)
           if n == 0:
               return 1
   
           result = 1
           while n != 0:
               if n % 2 != 0:
                   result *= x
               
               x *= x
               n //= 2
           return result
    ```
   </details>
