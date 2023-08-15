# Math
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

1. [202. Happy Number](https://leetcode.com/problems/happy-number)   
   There are 2 parts to the algorithm we'll need to design and code.  
   Given a number n, what is its next number?  
   Follow a chain of numbers and detect if we've entered a cycle.  

   ***Time complexity: O(logN + log logN ...) = O(logN), space complexity similarly is also O(logN)*** 
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
