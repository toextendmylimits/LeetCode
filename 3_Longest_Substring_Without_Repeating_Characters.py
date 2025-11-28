# Approach 1:
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        char_set = set()
        left = 0
        max_len = 0

        for right in range(len(s)):
            while s[right] in char_set:
                char_set.remove(s[left])
                left += 1

            char_set.add(s[right])
            max_len = max(max_len, right - left + 1)

        return max_len

Similar one using hash map:
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        left = 0
        max_len = 0
        freq = Counter()

        for right in range(len(s)):
            freq[s[right]] += 1

            # shrink window while this character is duplicated
            while freq[s[right]] > 1:
                freq[s[left]] -= 1
                left += 1

            max_len = max(max_len, right - left + 1)

        return max_len

# Approach 2

I use a sliding window and a map of each character’s last index.
When I see a duplicate inside the window, I move the left pointer to one past its previous position:
left = max(left, last_seen[ch] + 1).
This keeps the window valid.
At each step I update the max window size.
Since each character is processed once, it’s O(n)

Remember: left = max(left, last_seen[ch] + 1), otherwise wise the window could grow wrongly. Example: "abba"
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        last_seen = {}
        left = 0
        max_len = 0

        for right, ch in enumerate(s):
            if ch in last_seen:
                left = max(left, last_seen[ch] + 1)

            last_seen[ch] = right
            max_len = max(max_len, right - left + 1)

        return max_len
