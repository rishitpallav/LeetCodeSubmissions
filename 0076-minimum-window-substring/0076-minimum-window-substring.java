class Solution {
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) return "";

        int currentLength = Integer.MAX_VALUE;
        int[] indices = new int[]{-1,-1};

        // A - 65 till z - 122
        int[] tChars = new int[58];
        int[] sChars = new int[58];

        for (char c : t.toCharArray()) {
            tChars[c - 'A']++;
        }

        int left = 0;

        for (int right = 0; right < s.length(); right++ ) {
            boolean isPresent = true;

            sChars[s.charAt(right)-'A']++;

            for (int i = 0; i < 58; i++ ) {
                if (sChars[i] < tChars[i]) {
                    isPresent = false;
                    break;
                }
            }

            while (isPresent) {

                if (currentLength > (right - left)) {
                    currentLength = right - left + 1;
                    indices[0] = left;
                    indices[1] = right;
                }

                sChars[s.charAt(left) - 'A']--;
                left++;

                for (int i = 0; i < 58; i++ ) {
                    if (sChars[i] < tChars[i]) {
                        isPresent = false;
                        break;
                    }
                }
            }
        }

        return indices[0] == -1?"": s.substring(indices[0], indices[1]+1);
    }
}
