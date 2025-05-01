class Solution {
    public int[] diStringMatch(String s) {
        int lower = 0, upper = s.length();

        int[] result = new int[s.length() + 1];

        for (int i = 0; i < result.length - 1; i++ ) {
            if (s.charAt(i) == 'I') {
                result[i] = lower;
                lower++;
            } else {
                result[i] = upper;
                upper--;
            }
        }

        if (s.charAt(s.length() - 1) == 'I') {
            result[result.length - 1] = result[result.length - 2] + 1;
        } else {
            result[result.length - 1] = result[result.length - 2] - 1;
        }

        return result;
    }
}