class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {

        int n = nums.length;
        int left = 0;
        int right = queries.length;

        if (!getsZero(nums, queries, right)) return -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (getsZero(nums, queries, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    boolean getsZero(int[] nums, int[][] queries, int mid) {

        int[] prefix = new int[nums.length+1];

        for (int i = 0; i < mid; i++ ) {
            prefix[queries[i][0]] += queries[i][2];
            prefix[queries[i][1]+1] -= queries[i][2];
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