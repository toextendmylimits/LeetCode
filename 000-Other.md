# These don't fall into any category
1. [169. Majority Element](https://leetcode.com/problems/majority-element)  
    We increment a count variable every time we see the vote from the majority party and decrement it whenever a vote from some other party is occured , we can guarantee that, count>0.  

    Using the above logic ,  
    1. Create a count=0 and a majority variable that stores the current majority element.  
    1. Traverse the array , and if count =0 , then store the current element as the majority element and increment the count.  
    1. Else , if the current element is equal to the current majority element , increment count , else decrement it.  
    1. At the end return the majority element.
    <details>
      
    ```python
    def majorityElement(self, nums: List[int]) -> int:
        count = 0
        majority = None
        for n in nums:
            if count == 0:
                majority = n
            
            count += 1 if majority == n else -1
        
        return majority  
    ```
    </details>
1. [53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray)  
    <details>
      
    ```python
    def maxSubArray(self, nums: List[int]) -> int:
        currSum = nums[0] # represent the largest sum of subarray ending index i
        result = currSum

        for i in range(1, len(nums)):
            currSum = max(nums[i], currSum + nums[i])
            result = max(currSum, result)
        
        return result
      
    ```
    </details>
1. [384. Shuffle an Array](https://leetcode.com/problems/shuffle-an-array)  
    The idea is to pick a random card from all cards, and then swap this card with first card  
    Then pick a random card from remaining cards, and then swap this card with second card
   ***User random.randint or random.randrange(end exclusive) to generate random number***  
    <details>

        ```python
        def shuffle(self) -> List[int]:
            for i in range(len(self.currNums)):
                randIdx = random.randint(i, len(self.currNums) - 1)
                self.currNums[i], self.currNums[randIdx] = self.currNums[randIdx], self.currNums[i]
            
            return self.currNums
        ```
    </details>
1. [118. Pascal's Triangle](https://leetcode.com/problems/pascals-triangle)  
    row in range 1 and numRows(exclusive)  
    col in range 1 and row(exclusive)  
    ***Time complexity is O(N^2) while space complexity is O(1)***
    <details>
      
    ```python
        def generate(self, numRows: int) -> List[List[int]]:
            result = []
            result.append([1])
            if numRows == 1:
                return result
            
            for row in range(1, numRows):
                level = []
                level.append(1) # First
    
                for col in range(1, row):
                    prevLevel = result[-1]
                    level.append(prevLevel[col - 1] + prevLevel[col])
                
                level.append(1) # Last
                result.append(level)
            
            return result
      
    ```
    </details>   

1. [339. Nested List Weight Sum](https://leetcode.com/problems/nested-list-weight-sum)   
    Non-standard DFS and BFS. For BFS, use deque(nestedList) instead of deque([nestedList]) because nestedList is iterable collection already  
    TC O(N) Let N be the total number of nested elements in the input list. For example, the list [ [[[[1]]]], 2 ] contains 4 nested lists and 2 nested integers (1 and 2), so N=6 for that particular case. The recursive function is called once for each nested list. And for items directly inside a nestedlist, each item is visited only once.  
    SC O(D) deepest nested levels  
    <details>
      
    ```python
        def depthSum(self, nestedList: List[NestedInteger]) -> int:
            def calDepthSum(nestedList, depth):
                total = 0
                for element in nestedList:
                    if element.isInteger():
                        total += depth * element.getInteger()
                    else:
                        total += calDepthSum(element.getList(), depth + 1)
                
                return total
            
            return calDepthSum(nestedList, 1)

    # BFS
        def depthSum(self, nestedList: List[NestedInteger]) -> int:
            depth = 1
            total = 0
            queue = deque(nestedList)
    
            while queue:
                size = len(queue)
                for i in range(size):
                    currList = queue.popleft()
                    if currList.isInteger():
                        total += depth * currList.getInteger()
                    else:
                        for element in currList.getList():
                            queue.append(element)
                depth += 1
    
            return total    
    ```
    </details>   

1. [2437. Number of Valid Clock Times](https://leetcode.com/problems/number-of-valid-clock-times/) 
    Check all the possible hours and minutes and count all the choices that match the pattern.  
    <details>
      
    ```python
    def countTime(self, time: str) -> int:
        def is_pattern_match(s, pattern):
            for i in range(len(pattern)):
                if pattern[i] != "?" and pattern[i] != s[i]:
                    return False
            return True
        
        def format_two_chars(n):
            result = str(n)
            return "0" + result if n < 10 else result
        
        def get_choices(limit, pattern):
            choices = 0
            for i in range(limit):
                if is_pattern_match(format_two_chars(i), pattern):
                    choices += 1
            return choices
        
        hour_pattern, minute_pattern = time.split(":")
        return get_choices(24, hour_pattern) * get_choices(60, minute_pattern)       
    ```
    </details>   
