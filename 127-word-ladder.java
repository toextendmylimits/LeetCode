class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordListSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for(int i = 0; i < size; i++) {
                String word = queue.poll();
                if(word.equals(endWord)) {
                    return level;
                }
                
                for(String neighbour : getNeighbours(word, wordListSet)) {
                    if(visited.contains(neighbour)) {
                        continue;
                    }
                    queue.offer(neighbour);
                    visited.add(neighbour);
                }
            }
        }
        
        return 0;
    }
    
    private List<String> getNeighbours(String word, Set<String> wordListSet) {
        List<String> result = new ArrayList<>();
        for(int i = 0; i < word.length(); i++) {
            for(int j = 'a'; j <= 'z'; j++) {
                if((int) word.charAt(i) == j) {
                    continue;
                }
                
                char newChar = (char) j;
                String nextWord = word.substring(0, i) + newChar + word.substring(i + 1);
                if(wordListSet.contains(nextWord)) {
                    result.add(nextWord);
                }
            }
        }

        return result;
    }
}

Time complexity: O(M^2*N)
M is number of characters in string
N is word list
Explaniation:
GetNeighbours: loop O(M) times, each time construct a String of m characters takes O(M) so toether O(M^2)
Queue could loop O(N) times so together O(M^2*N)

Space complexity: O(M*N)
Queue has O(N) length, each queue element is of M characteers O(M) so together O(MN)
