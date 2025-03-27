class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        String longest = text1;
        String shortest = text2;
        if (text1.length() < text2.length()) {
            longest = text2;
            shortest = text1;
        }

        int n = longest.length(), m = shortest.length();

        int[] dp = new int[n+1];

        Arrays.fill(dp, 0);
        int previous = 0;
        
        for (int i = m-1; i >= 0; i-- ) {
            previous = 0;
            for (int j = n-1; j >= 0; j-- ) {
                int temp = dp[j];
                if (longest.charAt(j) == shortest.charAt(i)) {
                    dp[j] = 1 + previous;
                } else {
                    dp[j] = Math.max(dp[j], dp[j+1]);
                }
                previous = temp;
            }
        }

        return dp[0];

    }
}
