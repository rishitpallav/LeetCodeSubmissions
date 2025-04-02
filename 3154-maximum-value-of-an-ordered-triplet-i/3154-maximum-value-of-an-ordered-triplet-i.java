class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;

        int[] maxFromBeg = new int[n];
        int[] maxFromEnd = new int[n];

        maxFromEnd[n-1] = nums[n-1];

        int maxTillIndex = nums[0];

        for (int i = 0; i < n; i++ ) {
            maxTillIndex = Math.max(maxTillIndex, nums[i]);
            maxFromBeg[i] = maxTillIndex - nums[i];
        }

        for (int i = n-2; i >= 0; i-- ) {
            maxFromEnd[i] = Math.max(nums[i+1], maxFromEnd[i+1]);
        }

        long result = 0;

        for (int i = 0; i < n-1; i++ ) {
            result = Math.max(result, (long) (maxFromEnd[i]) * maxFromBeg[i]);
        }

        return result;
    }
}