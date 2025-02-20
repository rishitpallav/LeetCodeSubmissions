class Solution {
    public int characterReplacement(String s, int k) {
        int[] chars = new int[26];
        char[] cArr = s.toCharArray();
        int max = 0;
        int left = 0;
        int maxFreq = 0;

        for (int i = 0; i < cArr.length; i++ ) {
            chars[cArr[i] - 'A']++;
            maxFreq = Math.max(maxFreq, chars[cArr[i] - 'A']);

            while ((i - left + 1) - maxFreq > k) {
                chars[cArr[left++] - 'A']--;
            }
            max = Math.max(max, i - left +1);
        }

        return max;
    }
}