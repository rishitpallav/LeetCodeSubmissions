import java.util.*;
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        HashMap<AbstractMap.SimpleEntry<Integer, Integer>, Boolean> memo = new HashMap<>();
        return check (s1, s2, s3, 0, 0, memo);
    }

    boolean check(String s1, String s2, String s3, int s1P, int s2P, HashMap<AbstractMap.SimpleEntry<Integer, Integer>, Boolean> memo) {
        if (s1P == s1.length() && s2P == s2.length()) {
            return true;
        }

        AbstractMap.SimpleEntry<Integer, Integer> currentPair = new AbstractMap.SimpleEntry<>(s1P, s2P);

        if (memo.containsKey(currentPair)) {
            return memo.get(currentPair);
        }

        boolean result = false;

        if (s1P < s1.length() && s1.charAt(s1P) == s3.charAt(s1P + s2P) && check(s1, s2, s3, s1P+1, s2P, memo)) {
            result = true;
        }

        if (s2P < s2.length() && s2.charAt(s2P) == s3.charAt(s1P + s2P) && check(s1, s2, s3, s1P, s2P+1, memo)) {
            result = true;
        }
        memo.put(currentPair, result);
        return result;
    }
}