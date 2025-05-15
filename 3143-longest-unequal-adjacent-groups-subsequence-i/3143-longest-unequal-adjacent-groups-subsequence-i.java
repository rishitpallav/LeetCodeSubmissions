class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        boolean setBit = groups[0] == 1;
        result.add(words[0]);

        for (int i = 1; i < words.length; i++ ) {
            if (setBit && groups[i] == 0) {
                setBit = false;
                result.add(words[i]);
            } else if (!setBit && groups[i] == 1) {
                setBit = true;
                result.add(words[i]);
            }
        }

        return result;
    }
}