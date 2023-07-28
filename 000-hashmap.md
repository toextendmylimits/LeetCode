# Hashmap
1. [242. Valid Anagram](https://leetcode.com/problems/valid-anagram/)  
   Two strings are valid anagram if they same distinct characters, and for each distinct character, the number of times it appear in both string should also be the same    
   Time compexity is O(N), space complexity is essentially O(1) as there are only 26 lowercase letters
   <details>
      
    ```python
      def isAnagram(self, s: str, t: str) -> bool:
          counterS = Counter(s)
          counterT = Counter(t)
          if len(counterS) != len(counterT):
             return False
      
          for letter in counterS.keys():
              if counterS[letter] != counterT[letter]:
                  return False
  
          return True
    ```
   </details>
