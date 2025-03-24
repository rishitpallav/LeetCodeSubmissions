class Solution {
    public int countSubstrings(String s) {
        int result = s.length();

        for (int i = 0; i < s.length(); i++ ) {
            result += findNumberOfPalindromes(s, i, i+1);
            result += findNumberOfPalindromes(s, i-1, i+1);
        }

        return result;
    }

    int findNumberOfPalindromes (String s, int left, int right) {
        int count = 0;

        while (left > -1 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                return count;
            }
            left--;
            right++;
            count++;
        }

        return count;
    }
}
