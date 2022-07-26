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
            char lowerA = 'a';
            int diffToLowerA = word.charAt(i) - lowerA;
            for(int j = 0; j < 26; j++) {
                if(j == diffToLowerA) {
                    continue;
                }
                
                char newChar = (char)(j + ((int) lowerA));
                String nextWord = word.substring(0, i) + String.valueOf(newChar) + word.substring(i + 1);
                if(wordListSet.contains(nextWord)) {
                    result.add(nextWord);
                }
            }
        }

        return result;
    }
}
