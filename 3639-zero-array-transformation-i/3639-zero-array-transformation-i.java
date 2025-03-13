class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] prefix = new int[nums.length+1];

        for (int[] q : queries) {
            prefix[q[0]] += 1;
            prefix[q[1]+1] -= 1;
        }

        if (prefix[0] < nums[0]) return false;

        for (int i = 1; i < nums.length; i++ ) {
            prefix[i] += prefix[i-1];
            if (prefix[i] < nums[i]) {
                return false;
            }
        }

        return true;
    }
}