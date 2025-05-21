class Solution {
    public String lastSubstring(String s) {
        int left = 0, right = 1, k = 0;

        while (right + k < s.length()) {
            if (s.charAt(left+k) == s.charAt(right+k)) {
                k++;
            } else if (s.charAt(left+k) < s.charAt(right+k)) {
                left = Math.max(left + k + 1, right);
                right = left + 1;
                k = 0;
            } else {
                right = right + k + 1;
                k = 0;
            }
        }


        return s.substring(left);
    }
}