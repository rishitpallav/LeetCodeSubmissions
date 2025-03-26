class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int previous = 0;
        int result = 0;

        for (int i = 1; i < nums.length; i++ ) {
            if (nums[i] <= nums[i-1]) {
                result = Math.max(result, i - previous);
                previous = i;
            }
        }

        return Math.max(result, nums.length - previous);
    }
}