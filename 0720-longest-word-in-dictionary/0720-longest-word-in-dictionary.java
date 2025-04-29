class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);

        Set<String> wordSet = new HashSet<>();
        wordSet.add("");
        String longestWord = "";

        for (String word : words) {
            String prefix = word.substring(0, word.length() - 1);
            if (wordSet.contains(prefix)) {
                wordSet.add(word);
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }
        }

        return longestWord;
    }
}