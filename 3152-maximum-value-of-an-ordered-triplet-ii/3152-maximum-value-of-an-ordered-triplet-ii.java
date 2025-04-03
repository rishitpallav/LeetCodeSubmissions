class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;

        int[] maxFromEnd = new int[n];

        int max = nums[n-1];

        for (int i = n-1; i > -1; i-- ) {
            maxFromEnd[i] = max;
            max = Math.max(max, nums[i]);
        }

        max = nums[0];
        long result = 0;

        for (int i = 0; i < n-1; i++ ) {
            max = Math.max(max, nums[i]);
            result = Math.max(result, (long) (max - nums[i]) * maxFromEnd[i]);
        }

        return result;
    }
}