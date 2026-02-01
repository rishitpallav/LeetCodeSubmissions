class Solution {
    public boolean canJump(int[] nums) {
        int currentMax = nums[0];

        for (int i = 0; i < nums.length; i++ ) {
            if (currentMax == 0) return false;

            currentMax = Math.max(currentMax - 1, nums[i]);
        }

        return true;
    }
}