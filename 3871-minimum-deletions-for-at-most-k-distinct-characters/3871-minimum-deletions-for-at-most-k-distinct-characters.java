class Solution {
    public int minDeletion(String s, int k) {

        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        Arrays.sort(freq);

        int result = 0;
        for (int i = 25; i >= 0; i-- ) {
            if (freq[i] != 0) {
                if (k > 0) {
                    k--;
                } else {
                    result += freq[i];
                }
            }
        }

        return result;
    }
}