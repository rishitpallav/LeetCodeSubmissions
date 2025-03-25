class Solution {
    Map<Integer, Boolean> indexToResMemo;
    public boolean wordBreak(String s, List<String> wordDict) {
        indexToResMemo = new HashMap<>();
        Set<String> wordDictSet = new HashSet<>();
        for (String word : wordDict) {
            wordDictSet.add(word);
        }

        return dfs (s, wordDictSet, 0);
    }

    boolean dfs (String s, Set<String> wordDictSet, int index) {
        if (index >= s.length()) {
            return true;
        }

        if (indexToResMemo.containsKey(index)) {
            return indexToResMemo.get(index);
        }

        boolean res = false;

        for (int i = index+1; i <= s.length(); i++ ) {
            boolean result = false;
            if (wordDictSet.contains(s.substring(index, i))) {
                result = dfs (s, wordDictSet, i);
            }
            if (result == true) {
                indexToResMemo.put(index, true);
                return true;
            }
        }

        indexToResMemo.put(index, false);
        return false;
    }
}
