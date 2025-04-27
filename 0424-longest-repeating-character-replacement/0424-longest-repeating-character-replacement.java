class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0, result = 0;
        int totalCount = 0, maxCount = 0;
        char maxChar = s.charAt(0);

        for (int right = 0; right < s.length(); right++ ) {
            freq[s.charAt(right) - 'A']++;
            totalCount++;
            maxCount = Math.max(maxCount, freq[s.charAt(right) - 'A']);

            while (totalCount - maxCount > k) {
                freq[s.charAt(left) - 'A']--;
                totalCount--;
                left++;
            }

            result = Math.max(result, totalCount);
        }

        return result;
    }
}