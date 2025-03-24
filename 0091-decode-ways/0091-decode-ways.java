class Solution {
    
    HashMap<Integer, Integer> dp;
    public int numDecodings(String s) {
        dp = new HashMap<>();
        return numDecodings(s, 0);
    }

    int numDecodings(String s, int currentIndex) {
        if (dp.containsKey(currentIndex)) {
            return dp.get(currentIndex);
        }

        if (currentIndex == s.length()) {
            return 1;
        }

        if (s.charAt(currentIndex) == '0') {
            return 0;
        }

        int res = numDecodings(s, currentIndex+1);
        if (currentIndex+1 < s.length() && (s.charAt(currentIndex) == '1' || (s.charAt(currentIndex) == '2' && s.charAt(currentIndex+1) < '7'))) {
            res += numDecodings(s, currentIndex+2);
        }

        dp.put(currentIndex, res);

        return res;
    }
}
