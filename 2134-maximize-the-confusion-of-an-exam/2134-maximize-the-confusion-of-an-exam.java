class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int tcount = 0;
        int fcount = 0;

        int left = 0;

        int max = 0;

        char[] ansChars = answerKey.toCharArray();

        for (char c : ansChars) {
            if (c == 'T') {
                tcount++;
            } else {
                fcount++;
            }
            if (tcount > k && fcount > k) {
                max = Math.max(tcount + fcount - 1, max);
                while (tcount > k && fcount > k) {
                    if (ansChars[left++] == 'T') {
                        tcount--;
                    } else {
                        fcount--;
                    }
                }
            }
        }

        max = Math.max(tcount + fcount, max);

        return max;
    }
}