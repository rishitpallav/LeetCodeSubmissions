class Solution {
    Set<String> numbers;
    int memo[];
    public int numDecodings(String s) {
        memo = new int[s.length()];
        numbers = new HashSet<>();
        
        for (int i = 1; i < 27; i++ ) {
            numbers.add(i+"");
        }
        Arrays.fill(memo, -1);

        return numDecodings(s, 0);
    }

    int numDecodings(String s, int i) {
        if (i == s.length()) {
            return 1;
        }

        if (i > s.length()) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        int total = 0;

        if (numbers.contains(s.substring(i, i+1))) {
            total += numDecodings(s, i+1);
        }
        if (i < s.length() - 1 &&numbers.contains(s.substring(i, i+2))) {
            total += numDecodings(s, i+2);
        }

        memo[i] = total;

        return total;
    }
}