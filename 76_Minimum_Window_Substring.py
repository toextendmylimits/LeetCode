# Sliding window
I use a sliding window with two counters: required_count tells me how many of each character I need, and window_count tracks what the current window contains.
required_types is the number of distinct characters needed, and satisfied_types is how many of those are currently satisfied.

I expand the window with the right pointer until all required types are satisfied.
Once the window is valid, I shrink from the left to find the smallest possible valid window, updating the best answer.
This guarantees O(n) time because each pointer only moves forward.
  
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        required_count = Counter(t)          # required frequencies of t
        window_count = Counter()             # current window frequencies

        required_types = len(required_count) # number of distinct chars required
        satisfied_types = 0                  # number of distinct chars satisfied

        left = 0
        best_len = float('inf')
        best_start = -1

        for right in range(len(s)):
            ch = s[right]

            # expand window
            if ch in required_count:
                window_count[ch] += 1
                if window_count[ch] == required_count[ch]:
                    satisfied_types += 1

            # shrink window
            while satisfied_types == required_types:
                curr_len = right - left + 1
                if curr_len < best_len:
                    best_len = curr_len
                    best_start = left

                left_char = s[left]
                if left_char in required_count:
                    if window_count[left_char] == required_count[left_char]:
                        satisfied_types -= 1
                    window_count[left_char] -= 1

                left += 1

        return "" if best_start == -1 else s[best_start : best_start + best_len]

