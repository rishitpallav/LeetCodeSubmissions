class Solution {
    Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length()][p.length()];
        
        return isMatch(s, p, 0, 0);
    }

    boolean isMatch(String s, String p, int sPointer, int pPointer) {
        
        if (pPointer == p.length()) {
            return sPointer == s.length();
        }

        if (sPointer == s.length()) {
            for (int i = pPointer; i < p.length(); i++ ) {
                if (p.charAt(i) != '*') return false;
            }
            return true;
        }

        if (memo[sPointer][pPointer] != null) return memo[sPointer][pPointer];

        boolean match = false;
        
        if (p.charAt(pPointer) == '*') {
            match = isMatch(s, p, sPointer, pPointer+1) || (sPointer < s.length() && isMatch(s, p, sPointer+1, pPointer));
        } else if (s.charAt(sPointer) == p.charAt(pPointer) || p.charAt(pPointer)=='?') {
            match = isMatch(s, p, sPointer+1, pPointer+1);
        }

        memo[sPointer][pPointer] = match;

        return match;
    }
}