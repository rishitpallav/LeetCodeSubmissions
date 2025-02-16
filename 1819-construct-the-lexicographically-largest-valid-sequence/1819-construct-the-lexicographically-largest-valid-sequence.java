class Solution {
    int[] result;
    boolean[] used;
    public int[] constructDistancedSequence(int n) {
        result = new int[(2*n)-1];
        used = new boolean[n+1];

        fillSequence(n);

        return result;
    }

    boolean fillSequence(int n) {
        int current = 0;
        for (; current < result.length; current++ ) {

            if (result[current] != 0) continue;

            for (int i = n; i > 0; i-- ) {

                if (used[i]) continue;

                if (i == 1 || (current + i < result.length && result[current+i] == 0)) {
                    used[i] = true;
                    result[current] = i;
                    if (i > 1) result[current + i] = i;
                    if (fillSequence(n)) {
                        return true;
                    }
                    result[current] = 0;
                    if (i > 1) result[current + i] = 0;
                    used[i] = false;
                }
            }
            return false;
        }
        return true;
    }
}