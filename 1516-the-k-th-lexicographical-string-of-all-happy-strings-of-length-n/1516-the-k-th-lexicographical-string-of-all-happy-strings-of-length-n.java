class Solution {
    int times;
    String result;
    public String getHappyString(int n, int k) {
        times = 0;
        result = "";

        buildString(n, k, new StringBuilder(), ' ');

        return result;
    }

    void buildString(int n, int k, StringBuilder s, char previousChar) {
        if (s.length() == n) {
            times++;
            if (times == k) {
                result = s.toString();
            }
            return;
        }

        for (char c = 'a'; c <= 'c'; c++) {
            if (c != previousChar) {
                s.append(c);
                buildString(n, k, s, c);
                s.deleteCharAt(s.length() -1);
                if (!result.isEmpty()) {
                    return;
                }
            }
        }
    }
}