class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for (String ban : banned) bannedSet.add(ban);
        bannedSet.add("");
        Map<String, Integer> commonWords = new HashMap<>();
        int previousIndex = 0;
        for (int i = 0; i < paragraph.length(); i++ ) {
            if (!Character.isLetter(paragraph.charAt(i))) {
                String word = paragraph.substring(previousIndex, i).toLowerCase();
                commonWords.put(word, commonWords.getOrDefault(word, 0)+1);
                previousIndex = i+1;
            }
        }

        String word = paragraph.substring(previousIndex).toLowerCase();
        commonWords.put(word, commonWords.getOrDefault(word, 0)+1);

        String commonWord = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : commonWords.entrySet()) {
            if (maxCount < entry.getValue() && !bannedSet.contains(entry.getKey())) {
                maxCount = entry.getValue();
                commonWord = entry.getKey();
            }
        }

        return commonWord;
    }
}