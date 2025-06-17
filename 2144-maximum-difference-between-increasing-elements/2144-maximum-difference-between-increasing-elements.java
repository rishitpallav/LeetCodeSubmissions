class Solution {
    public int maximumDifference(int[] nums) {
        int min = nums[0], max = nums[1];
        int difference = -1;

        for (int i = 1; i < nums.length; i++ ) {
            if (min > nums[i]) {
                min = nums[i];
                max = min-1;
                continue;
            }
            if (max < nums[i]) max = nums[i];
            difference = Math.max(difference, max-min);
        }

        return difference > 0 ? difference : -1;
    }
}