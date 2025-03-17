class Solution {
    public boolean divideArray(int[] nums) {
        boolean[] result = new boolean[501];

        int max = 0;

        for (int i : nums) {
            max = Math.max(max, i);
            result[i] = !result[i];
        }

        for (int i = 0; i < max; i++ ) {
            if (result[i]) return false;
        }

        return true;
    }
}