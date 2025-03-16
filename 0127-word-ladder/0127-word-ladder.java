class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<Integer>> wordToIndex = new HashMap<>();

        for (int i = 0; i < wordList.size(); i++ ) {
            char[] spit = wordList.get(i).toCharArray();
            for (int j = 0; j < spit.length; j++ ) {
                char c = spit[j];
                spit[j] = '*';
                String water = new String(spit);
                wordToIndex.computeIfAbsent(water, k -> new ArrayList<>()).add(i);
                spit[j] = c;
            }
        }

        Queue<String> current = new LinkedList<>();
        current.add(beginWord);

        boolean[] visited = new boolean[wordList.size()];
        
        int result = 1;

        while (!current.isEmpty()) {
            Queue<String> next = new LinkedList<>();

            while (!current.isEmpty()) {
                char[] spit = current.poll().toCharArray();
                for (int j = 0; j < spit.length; j++ ) {
                    char c = spit[j];
                    spit[j] = '*';
                    String word = new String(spit);
                    if (wordToIndex.containsKey(word)) {
                        for (int index : wordToIndex.get(word)) {
                            if (wordList.get(index).equals(endWord)) {
                                return result+1;
                            }
                            if (!visited[index]) {
                                next.add(wordList.get(index));
                                visited[index] = true;
                            }
                        }
                    }
                    spit[j] = c;
                }
            }
            current = next;
            result++;
        }

        return 0;
    }
}
