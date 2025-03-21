class Solution {
    public char findTheDifference(String s, String t) {
        int n = 0;

        for (char c : s.toCharArray()) {
            n ^= (int)c;
        }

        for (char c : t.toCharArray()) {
            n ^= (int)c;
        }

        return (char)n;
    }
}