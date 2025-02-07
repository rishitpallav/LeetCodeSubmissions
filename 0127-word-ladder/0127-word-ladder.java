class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> dict = new HashMap<>();

        Set<String> wordSet = new HashSet<>();

        for (String w : wordList) {
            wordSet.add(w);
        }

        wordList.add(beginWord);

        for (int i = 0; i < wordList.size(); i++ ) {
            dict.put(wordList.get(i), relatedWords(wordList.get(i), wordSet));
        }

        Queue<String> bfsQueue = new LinkedList<>();
        bfsQueue.add(beginWord);


        Set<String> previousEncountered = new HashSet<>();
        int result = 1;
        while (!bfsQueue.isEmpty()) {
            Queue<String> newBfsQueue = new LinkedList<>();
            result++;
            while (!bfsQueue.isEmpty()) {
                List<String> relatedStrings = dict.get(bfsQueue.poll());
                for (String s : relatedStrings) {
                    if (s.equals(endWord)) {
                        return result;
                    }
                    if (!previousEncountered.contains(s)) {
                        newBfsQueue.add(s);
                        previousEncountered.add(s);
                    }
                }
            }
            bfsQueue = newBfsQueue;
        }

        return 0;
    }

    public List<String> relatedWords(String s, Set<String> wordSet) {
        List<String> result = new ArrayList<>();
        char[] sCharArray = s.toCharArray();

        for (int i = 0; i < sCharArray.length; i++ ) {
            char originalCharacter = sCharArray[i];
            for (char j = 'a'; j <= 'z'; j++ ) {
                if (j == originalCharacter) {
                    continue;
                }
                sCharArray[i] = j;
                if (wordSet.contains(new String(sCharArray))) {
                    result.add(new String(sCharArray));
                }
            }
            sCharArray[i] = originalCharacter;
        }

        return result;
    }
}