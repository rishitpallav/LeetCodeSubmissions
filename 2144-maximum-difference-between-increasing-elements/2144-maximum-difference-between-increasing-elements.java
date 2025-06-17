class Solution {
    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int difference = -1;

        for (int num : nums ) {
            if (min == num) continue;
            difference = Math.max(difference, num-min);
            min = Math.min(min, num);
        }

        return difference;
    }
}