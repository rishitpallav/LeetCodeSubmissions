class Solution {
    public String minimumString(String a, String b, String c) {
        String result = null;

        String mergedAB = mergeTwoStrings(a, b);
        String mergedBA = mergeTwoStrings(b, a);
        String mergedAC = mergeTwoStrings(a, c);
        String mergedCA = mergeTwoStrings(c, a);
        String mergedBC = mergeTwoStrings(b, c);
        String mergedCB = mergeTwoStrings(c, b);

        String[] candidates = {
            mergeTwoStrings(a, mergedBC),
            mergeTwoStrings(a, mergedCB),
            mergeTwoStrings(b, mergedAC),
            mergeTwoStrings(b, mergedCA),
            mergeTwoStrings(c, mergedAB),
            mergeTwoStrings(c, mergedBA)
        };

        for (String candidate : candidates) {
            if (result == null || candidate.length() < result.length() || (candidate.length() == result.length() && candidate.compareTo(result) < 0)) {
                result = candidate;
            }
        }

        return result;
    }

    String mergeTwoStrings(String a, String b) {
        
        if (a.contains(b)) return a;
        if (b.contains(a)) return b;

        for (int i = 0; i < a.length(); i++ ) {
            int left = i;
            int j = 0;
            while (a.charAt(left) == b.charAt(j)) {
                left++;
                j++;
                if (left == a.length()) {
                    return a.substring(0, i) + b;
                }
                if (j == b.length()) {
                    break;
                }
            }
        }
        return a + b;
    }
}