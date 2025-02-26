class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int current_max = nums[0];
        int current_min = nums[0];

        int all_time_max = current_max;
        int all_time_min = current_min;

        for (int i = 1; i < nums.length; i++ ) {
            current_max = Math.max(nums[i], current_max + nums[i]);
            current_min = Math.min(nums[i], current_min + nums[i]);

            all_time_max = Math.max(all_time_max, current_max);
            all_time_min = Math.min(all_time_min, current_min);
        }

        return Math.max(all_time_max, Math.abs(all_time_min));
    }
}