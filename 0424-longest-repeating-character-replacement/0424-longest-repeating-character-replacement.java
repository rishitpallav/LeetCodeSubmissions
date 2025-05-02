class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0, result = 0;
        int maxFreq = 0;

        for (int right = 0; right < s.length(); right++ ) {
            int current = s.charAt(right) - 'A';
            freq[current]++;
            if (freq[current] > maxFreq) {
                maxFreq = freq[current];
            }

            // Reducing the sliding window
            if (k < (right - left + 1) - maxFreq) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // Updating the result
            result = Math.max(result, (right - left) + 1);
        }
        
        return Math.max(result, s.length() - left);
    }
}