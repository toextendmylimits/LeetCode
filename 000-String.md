# String
1. [1592. Rearrange Spaces Between Words](https://leetcode.com/problems/rearrange-spaces-between-words)
   The idea is to find the words and spaces.  
    <details>

      ```python
    def reorderSpaces(self, text: str) -> str:
        words = text.split()
        total_spaces = text.count(" ")     
        gaps = len(words) - 1
        if gaps == 0:
            return words[0] + (" " * total_spaces)

        even_spaces_in_gap, exra_spaces = divmod(total_spaces, gaps)
        line = [words[0]]
        for i in range(1, len(words)):
            line.append(" " * even_spaces_in_gap)
            line.append(words[i])
        
        line.append(" " * exra_spaces)
        return "".join(line)
      ```
    </details>   
1. [68. Text Justification](https://leetcode.com/problems/text-justification)  
   The idea is to find the words that can fit into a line. If there is only one word or the line is the last one, then it should be left justified. Otherwise, check how many spaces are there. If the spaces are even, distribute them evenly between words, else add one extra space between two words starting from the left.
    <details>

      ```python
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        def get_spaces(n):
            return " " * n

        i = 0
        result = []
        while i < len(words):
            len_line_no_justify = len(words[i])
            j = i + 1
            while j < len(words) and len_line_no_justify + 1 + len(words[j]) <= maxWidth:
                len_line_no_justify += 1 + len(words[j])
                j += 1
            
            line = [words[i]]
            if j == i + 1 or j == len(words):
                for k in range(i + 1, j):
                    line.append(get_spaces(1))
                    line.append(words[k])
            
                line.append(get_spaces(maxWidth - len_line_no_justify))
            else:
                gaps = j - i - 1
                total_spaces = maxWidth - (len_line_no_justify - gaps)
                even_spaces_in_gap, extra_spaces = divmod(total_spaces, gaps)

                for k in range(i + 1, j):
                    if extra_spaces > 0:
                        line.append(get_spaces(even_spaces_in_gap + 1))
                        line.append(words[k]) 
                        extra_spaces -= 1
                    else:
                        line.append(get_spaces(even_spaces_in_gap))
                        line.append(words[k])
            i = j
            result.append("".join(line))
        return result
      ```
    </details>      
1. [408. Valid Word Abbreviation](https://leetcode.com/problems/valid-word-abbreviation)  
   Two pointers.   
    1. If j at abbr is alphabetic character, then check whether it is the same character at i position of word; If not, return False; If so, advance both i and j  
    1. IF j at abbr is not alphabetic character, then it must be a numeric digit. If it's zero, return False straight way. Otherwise, find the numerical value which represents the length of substring, and advance i by that length
    1. In the end, check whether both pointers reach the end of string  
    <details>

      ```python
    def validWordAbbreviation(self, word: str, abbr: str) -> bool:
        i = 0
        j = 0
        while i < len(word) and j < len(abbr):
            if abbr[j].isalpha():
                if abbr[j] == word[i]:
                    i += 1
                    j += 1
                else:
                    return False
            else:
                if abbr[j] == "0":
                    return False
                strLen = 0
                while j < len(abbr) and abbr[j].isdigit():
                    strLen = 10 * strLen + int(abbr[j])
                    j += 1
                i += strLen
        return i == len(word) and j == len(abbr)
      ```
    </details>   
    
1. [387. First Unique Character in a String](https://leetcode.com/problems/first-unique-character-in-a-string)    
    Use hash map to store each charcter, and how many times it appear in the string  
    Loop through the string, and if any character appear only once, return its index  
    In the end, return -1
    <details>

      ```python
        def firstUniqChar(self, s: str) -> int:
            counter = Counter(s)
            for i, ch in enumerate(s):
                if counter[ch] == 1:
                    return i
            
            return -1
      ```
    </details>   

1. [242. Valid Anagram](https://leetcode.com/problems/valid-anagram)      
    For each string, use a hash map to store each charcter, and how many times it appear in the string  
    Then compare with the two hash map has same keys and values  
    <details>

      ```python
        def firstUniqChar(self, s: str) -> int:
            counter = Counter(s)
            for i, ch in enumerate(s):
                if counter[ch] == 1:
                    return i
            
            return -1
      ```
    </details>  
        
1. [14. Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix)  
    The prefix must shorter than the first word.   
    1. Scan the first word, and for each character, check whether it exists in all the remaining words
    1. Scan the words, if the charcter doesn't exist in a word, then the prefix is found, return it, otherwise continue
    1. In the end, all characters of first word must exist in the remaining words, so just return the first word   
        <details>
            
            ```python
                def longestCommonPrefix(self, strs: List[str]) -> str:
                    if not strs:
                        return ""
                        
                    result = []
                    firstStr = strs[0]
                    for i in range(len(firstStr)):
                        for j in range(1, len(strs)):
                            if i >= len(strs[j]) or strs[j][i] != firstStr[i]:
                                return firstStr[:i]
                        
                    return firstStr
            ```
        </details>

1. [28. Find the Index of the First Occurrence in a String](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string)  
    A very intuitive approach is to traverse each possible substring of same length as needle in the haystack, and check if it equals to needle.
    1. Declare i represent index of needle, and j represent index of haystack, 
    1. Iterate i from 0 to len(haystack) - len(needle), in each interation
    1. Iterate j from 0 to len(needle) - 1, 
    1. In each iteration, check whether needle[j] == haystack[i + j] 
    1. If not equal, break out of the loop for iteration j
    1. If equal, check whether j equal to len(needle) - 1, if so the needle has been found, return i
    1. Return -1 in the end
    <details>

      ```python
        def strStr(self, haystack: str, needle: str) -> int:
            for i in range(len(haystack) - len(needle) + 1):
               for j in range(len(needle)):
                    if haystack[i + j] != needle[j]:
                       break
                    
                    if j == len(needle) - 1:
                        return i
            return -1     
      ```
    </details>
1. [8. String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi)  
    <details>

      ```python
          def myAtoi(self, s: str) -> int:
              result = 0
              i = 0
              while i < len(s) and s[i] == " ":
                  i += 1
              
              sign = 1
              if i < len(s):
                  if s[i] == "-":
                      sign = -1
                      i += 1
                  elif s[i] == "+":
                      i += 1
              limit = 2 ** 31
              while i < len(s) and s[i].isnumeric():
                  result = result * 10 + (ord(s[i]) - ord("0"))
                  if result >= limit:
                      return limit - 1 if sign > 0 else -limit
                  i += 1
              
              return result * sign           
      ```
    </details>
1. [38. Count and Say](https://leetcode.com/problems/count-and-say)  
    <details>

      ```python
        def countAndSay(self, n: int) -> str:
            def count(s):
                count = 1
                currChar = s[0]
                result = []
                for i in range(1, len(s)):
                    ch = s[i]
                    if ch == currChar:
                        count += 1
                    else:
                        result.append(str(count) + currChar)
                        currChar = ch
                        count = 1
                result.append(str(count) + currChar)        
                return "".join(result)
                    
            result = "1"
            for i in range(2, n + 1):
                result = count(result)
            
            return result
         
      ```
    </details>

1. [392. Is Subsequence](https://leetcode.com/problems/is-subsequence)    
    <details>

      ```python
        def isSubsequence(self, s: str, t: str) -> bool:
            i = 0
            j = 0
            while i < len(s) and j < len(t):
                if t[j] == s[i]:
                    i += 1
                
                j += 1
            
            return i == len(s)      
      ```
    </details>

1. [151. Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string)   
    Need to implement split, reverse and join. Memorize the code   
    <details>

      ```python
        def join(self, words):
            result = ""
            for i, word in enumerate(words):
                result += (" " if i > 0 else "") + word
            return result
    
            
        def split(self, s):
            words = []
            currWord = ""
            for c in s:
                if c != " ":
                    currWord += c
                elif currWord:
                    words.append(currWord)
                    currWord = ""
            
            if currWord:
                words.append(currWord)
    
            return words
        def reverse(self, words):
            left = 0
            right = len(words) - 1
            while left < right:
                words[left], words[right] = words[right], words[left]
                left += 1
                right -= 1
            return words
    
        def reverseWords(self, s: str) -> str:
            return self.join(self.reverse(self.split(s)))    
      ```
    </details>
