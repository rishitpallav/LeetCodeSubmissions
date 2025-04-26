class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] elements = new boolean[256];

        int left = 0, result = 0;

        for (int right = 0; right < s.length(); right++ ) {
            // remove any duplicates
            while (elements[s.charAt(right)]) {
                elements[s.charAt(left++)] = false;
            }

            // add right to sliding window
            elements[s.charAt(right)] = true;

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}