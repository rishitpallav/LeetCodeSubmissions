class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] frequencies = new int[26];

        for (char c : s.toCharArray()) {
            frequencies[c - 'a']++;
        }

        List<Integer> result = new ArrayList<>();
        int left = -1, charCount = 0, fullMatch = 0;
        int[] currentFreq = new int[26];

        for (int right = 0; right < s.length(); right++ ) {
            char c = s.charAt(right);
            currentFreq[c - 'a']++;
            if (currentFreq[c - 'a'] == 1) {
                charCount++;
            }
            if (currentFreq[c-'a'] == frequencies[c-'a']) {
                fullMatch++;
            }
            if (fullMatch == charCount) {
                result.add(right - left);
                fullMatch = 0;
                charCount = 0;
                left = right;
            }
        }

        return result;
    }
}