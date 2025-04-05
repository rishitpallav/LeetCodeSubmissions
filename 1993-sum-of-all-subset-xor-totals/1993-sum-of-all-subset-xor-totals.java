class Solution {
    public int subsetXORSum(int[] nums) {
        return dp (nums, 0, 0);
    }

    int dp (int[] nums, int index, int total) {
        if (index == nums.length) {
            return total;
        }
        return dp (nums, index+1, total ^ nums[index]) + dp (nums, index+1, total);
    }
}