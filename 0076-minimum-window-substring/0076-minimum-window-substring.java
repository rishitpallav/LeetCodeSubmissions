class Solution {
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) return "";

        int currentLength = Integer.MAX_VALUE;
        int[] indices = new int[]{-1,-1};

        // A - 65 till z - 122
        int[] tChars = new int[58];
        int[] sChars = new int[58];

        int left = 0, have = 0, need = 0;

        for (char c : t.toCharArray()) {
            tChars[c - 'A']++;
            // new char inserted
            if (tChars[c - 'A'] == 1) {
                need++;
            }
        }

        for (int right = 0; right < s.length(); right++ ) {

            sChars[s.charAt(right) - 'A']++;

            // for every valid frequency
            if (sChars[s.charAt(right) - 'A'] == tChars[s.charAt(right) - 'A']) {
                have++;
            }

            while (have == need) {

                if (currentLength > (right - left)) {
                    currentLength = right - left + 1;
                    indices[0] = left;
                    indices[1] = right;
                }

                sChars[s.charAt(left) - 'A']--;

                // for every valid frequency lost
                if (sChars[s.charAt(left) - 'A'] < tChars[s.charAt(left) - 'A']) {
                    have--;
                }

                left++;
            }
        }

        return indices[0] == -1?"": s.substring(indices[0], indices[1]+1);
    }
}
