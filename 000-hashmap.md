# Hashmap
1. [791. Custom Sort String](https://leetcode.com/problems/custom-sort-string)  
   The idea is to first calculate the frequence of unique characters in s, then linear scan the order, if the relevant character appears i s, and it appears n times, then add that character n times to the result array, and then change its frequency to 0. In the end, add all the remaining characters to the result array.  TC O(len1 + len2) SC O(unique number of characters) = O(26) = O(1)  
   <details>
      
    ```python
       def customSortString(self, order: str, s: str) -> str:
           counter = Counter(s)
           result = []
           for c in order:
               while counter[c] > 0:
                   result.append(c)
                   counter[c] -= 1
                   
           for c, freq in counter.items():
               while freq > 0:
                   result.append(c)
                   freq -= 1
           
           return "".join(result)
    ```
   </details>

1. [249. Group Shifted Strings](https://leetcode.com/problems/group-shifted-strings)  
   The idea is to shift each string to a string starts with a. For example, for bcd, to shift b to a, we need to go back by 1, so c becomes b and d becomes c, hence it becomes abc.  TC O(N) SC O(N) where N is total number of characters  
   <details>
      
    ```python
       def groupStrings(self, strings: List[str]) -> List[List[str]]:
           def getHash(s):
               result = []
               offset = ord(s[0]) - ord("a")
               result.append("a")
               for i in range(1, len(s)):
                   c = s[i]
                   targetOrd = ord(s[i]) - offset
                   if targetOrd < ord("a"):
                       targetOrd += 26
   
                   result.append(chr(targetOrd))
           
               return "".join(result)
           
           groups = defaultdict(list)
           for s in strings:
               groups[getHash(s)].append(s)
           
           return groups.values()
    ```
   </details>   
   
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

1. [49. Group Anagrams](https://leetcode.com/problems/group-anagrams)   
   Calculate hash of a string as letter plus frequency, such as a2b3cd. Importantly, these letters must be sorted alphabetically  
     
   <details>
      
    ```python
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        def getHash(s):
            counter = Counter(s)
            result = []
            for ch, freq in sorted(counter.items()):
                result.append(ch)
                result.append(str(freq))

            return "".join(result)
        
        hashStringMap = {}
        for s in strs:
            hash = getHash(s)
            if hash in hashStringMap:
                hashStringMap[hash].append(s)
            else:
                hashStringMap[hash] = [s]
        
        return hashStringMap.values()
    ```
   </details>
   
1. [217. Contains Duplicate](https://leetcode.com/problems/contains-duplicate)     
   <details>
      
    ```python
    def containsDuplicate(self, nums: List[int]) -> bool:
        return len(nums) != len(set(nums))
    ```
   </details>

1. [219. Contains Duplicate II](https://leetcode.com/problems/contains-duplicate-ii/)
   <details>
      
    ```python
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        numMinMaxIdxMap = {}
        for i in range(len(nums)):
            n = nums[i]
            if n in numMinMaxIdxMap:
                idx = numMinMaxIdxMap[n]
                if i - idx <= k:
                    return True
                else:
                    numMinMaxIdxMap[n] = i
            else:
                numMinMaxIdxMap[n] = i
        
        return False
    ```
   </details>

1. [205. Isomorphic Strings](https://leetcode.com/problems/isomorphic-strings)  
   Convert all characters to index of first occurence. Use hash map to store index    
   <details>
      
    ```python
    def isIsomorphic(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        chIdxMapOfS = {}
        chIdxMapOfT = {}
        for i in range(len(s)):
            chOfS = s[i]
            chOfT = t[i]
            if chOfS in chIdxMapOfS and chOfT in chIdxMapOfT:
                if chIdxMapOfS[chOfS] != chIdxMapOfT[chOfT]:
                    return False
            elif not chOfS in chIdxMapOfS and not chOfT in chIdxMapOfT:
                chIdxMapOfS[chOfS] = i
                chIdxMapOfT[chOfT] = i
            else:
                return False
        
        return True
    ```
   </details>

1. [290. Word Pattern](https://leetcode.com/problems/word-pattern/) 
   Convert all characters/words to index of first occurence. Use hash map to store index    
   <details>
      
    ```python
    def wordPattern(self, pattern: str, s: str) -> bool:
        words = s.split()
        print(len(s) == len(words))
        if len(pattern) != len(words):
            return False

        letterFirstIdxMap = {}
        wordFirstIdxMap = {}
        for i in range(len(pattern)):
            letter = pattern[i]
            word = words[i]
            if letter in letterFirstIdxMap and word in wordFirstIdxMap:
                if letterFirstIdxMap[letter] != wordFirstIdxMap[word]:
                    return False
            elif not letter in letterFirstIdxMap and not word in wordFirstIdxMap:
                letterFirstIdxMap[letter] = i
                wordFirstIdxMap[word] = i
            else:
                return False
        
        return True
    ```
   </details>
