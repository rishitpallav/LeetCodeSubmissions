class Solution {
    Set<String> words;
    Map<Integer, Boolean> memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        words = new HashSet<>();
        memo = new HashMap<>();

        for (String word : wordDict) {
            words.add(word);
        }

        return dfs(s, 0);
    }

    boolean dfs (String s, int index) {
        if (index == s.length()) {
            return true;
        }

        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        for (int i = index+1; i < s.length()+1; i++ ) {
            if (words.contains(s.substring(index, i))) {
                if (dfs(s, i)) {
                    memo.put(index, true);
                    return true;
                }
            }
        }

        memo.put(index, false);

        return false;
    }
}