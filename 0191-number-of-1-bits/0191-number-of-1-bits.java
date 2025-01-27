class Solution {
    public int hammingWeight(int n) {
        int x = 1;
        int counter = 0;

        for (int i = 0; i < 31; i++ ) {
            if ((n & x) != 0) {
                counter++;
            }
            x = x<<1;
        }

        return counter;
    }
}