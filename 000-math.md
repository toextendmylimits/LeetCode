# Math
1.[204. Count Primes](https://leetcode.com/problems/count-primes)  
atestt
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
