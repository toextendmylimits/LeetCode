

Since strings can contain any character, we cannot safely use a delimiter.
I encode each string as length#string.
The length guarantees I know exactly how many characters to read during decode, so I don’t rely on the content.
Decoding scans for the #, reads the length, and extracts that many characters.
This works for all ASCII characters and gives O(n) encode/decode time.

class Codec:

    def encode(self, strs: List[str]) -> str:
        encoded = []
        for s in strs:
            encoded.append(str(len(s)) + "#" + s)
        return "".join(encoded)

    def decode(self, s: str) -> List[str]:
        idx = 0
        result = []

        while idx < len(s):
            # 1. Read length before "#"
            j = idx
            while s[j] != "#":
                j += 1
            length = int(s[idx:j])
            
            # 2. Extract the string
            start = j + 1
            end = start + length
            result.append(s[start:end])
            
            # Move index forward
            idx = end

        return result
