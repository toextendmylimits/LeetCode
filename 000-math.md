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
   Time complexity: O(logN + log logN ...) = O(logN), space complexity similarly is also O(logN)
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
   ***Approach 1 - Calculate factorial first and then counter trailing zeroes ***
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
