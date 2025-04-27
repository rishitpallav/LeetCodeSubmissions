class Solution {
    public boolean canJump(int[] nums) {

        if (nums.length == 1) return true;

        int maxReach = nums[0];

        for (int i = 0; i < nums.length; i++ ) {
            maxReach = Math.max(maxReach, nums[i]);
            if (maxReach == 0 && i != nums.length-1) return false;
            maxReach--;
        }

        return true;
    }
}