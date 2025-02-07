class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> dict = new HashMap<>();

        for (int i = 0; i < wordList.size(); i++ ) {
            List<String> valueSet = new ArrayList<>();
            for (int j = 0; j < wordList.size(); j++ ) {
                if (compareTwoStrings(wordList.get(i), wordList.get(j))) {
                    valueSet.add(wordList.get(j));
                }
            }
            dict.put(wordList.get(i), valueSet);
        }

        Queue<String> bfsQueue = new LinkedList<>();

        for (int i = 0; i < wordList.size(); i++ ) {
            if (compareTwoStrings(beginWord, wordList.get(i))) {
                bfsQueue.add(wordList.get(i));
                if (wordList.get(i).equals(endWord)) {
                    return 2;
                }
            }
        }

        Set<String> previousEncountered = new HashSet<>();
        int result = 2;
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

    public boolean compareTwoStrings(String s1, String s2) {
        boolean caught = false;
        for (int i = 0; i < s1.length(); i++ ) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (caught) {
                    return false;
                }
                caught = true;
            }
        }
        return true;
    }
}