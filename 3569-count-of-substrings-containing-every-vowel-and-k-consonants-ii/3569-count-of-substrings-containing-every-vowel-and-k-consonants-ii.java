class Solution {
    public long countOfSubstrings(String word, int k) {
        Map<Character, Integer> currentVowels = new HashMap<>();

        int[] nextConsonent = new int[word.length()];
        int consonentIndex = word.length();

        for (int i = word.length() - 1; i > -1; i-- ) {
            nextConsonent[i] = consonentIndex;
            if (word.charAt(i) != 'a' && word.charAt(i) != 'e' && word.charAt(i) != 'i' && word.charAt(i) != 'o' && word.charAt(i) != 'u') {
                consonentIndex = i;
            }
        }

        int left = 0;
        int right = 0;
        int consonents = 0;
        long result = 0;

        while (right < word.length()) {
            char c = word.charAt(right);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                currentVowels.put(c, currentVowels.getOrDefault(c, 0)+1);
            } else {
                consonents++;
            }
            while (consonents > k) {
                char leftChar = word.charAt(left);
                if (leftChar == 'a' || leftChar == 'e' || leftChar == 'i' || leftChar == 'o' || leftChar == 'u') {
                    currentVowels.put(leftChar, currentVowels.get(leftChar) - 1);
                    if (currentVowels.get(leftChar) == 0) {
                        currentVowels.remove(leftChar);
                    }
                } else {
                    consonents--;
                }
                left++;
            }
            
            while (left < word.length() && currentVowels.keySet().size() == 5 && consonents == k) {
                result += nextConsonent[right] - right;
                char leftChar = word.charAt(left);
                if (leftChar == 'a' || leftChar == 'e' || leftChar == 'i' || leftChar == 'o' || leftChar == 'u') {
                    currentVowels.put(leftChar, currentVowels.get(leftChar) - 1);
                    if (currentVowels.get(leftChar) == 0) {
                        currentVowels.remove(leftChar);
                    }
                } else {
                    consonents--;
                }
                left++;
            }
            right++;
        }
        return result;
    }
}