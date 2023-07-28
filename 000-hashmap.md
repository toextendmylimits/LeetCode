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
   
1. [409. Longest Palindrome](https://leetcode.com/problems/longest-palindrome)   
   Suppose n represent the number of times a character appear in a string 
   1. If a charcter appears even number of times, always include this character for n times
   1. If there are characters appear odd number of times, then one character could be in the middle, while for all the other characters, they can only appear n -1 times
   <details>
      
    ```python
    def longestPalindrome(self, s: str) -> int:
        counter = Counter(s)
        maxLen = 0
        hasOddCount = False
        for count in counter.values():
            if count % 2 == 0:
                maxLen += count
            else:
                hasOddCount = True
                maxLen += count - 1
        if hasOddCount:
            maxLen += 1
        return maxLen
    ```
   </details>

1. [383. Ransom Note](https://leetcode.com/problems/ransom-note)     
   Let me be length of magazine, then time complexity is O(m) and space complexity is O(1). Remember to return False immediately if length of ransom note is larger than length of magazine
   <details>
      
    ```python
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        if len(ransomNote) > len(magazine):
            return False
            
        counterNote = Counter(ransomNote)
        counterMagazine = Counter(magazine)
        for letter, count in counterNote.items():
            if counterMagazine[letter] < count:
                return False

        return True
    ```
   </details>
