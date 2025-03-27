class Solution {
    public int minFlips(int a, int b, int c) {
        int total = 0;

        while (a > 0 || b > 0 || c > 0) {
            boolean aOn = (a & 1) == 1;
            boolean bOn = (b & 1) == 1;
            boolean cOn = (c & 1) == 1;

            a = a >> 1;
            b = b >> 1;
            c = c >> 1;

            if (cOn) {
                if (aOn || bOn) {
                    continue;
                } else {
                    total++;
                }
            } else {
                if (aOn && bOn) {
                    total += 2;
                } else if (aOn) {
                    total++;
                } else if (bOn) {
                    total++;
                }
            }
        }

        return total;
    }
}