class Solution {
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }
        if (totalSum%2 != 0) return false;

        memo = new Boolean[nums.length][totalSum / 2 + 1];

        return dfs (nums, 0, totalSum/2);

    }

    boolean dfs (int[] nums, int index, int target) {
        if (index == nums.length) {
            return target == 0;
        }

        if (target < 0) return false;

        if (memo[index][target] != null) {
            return memo[index][target];
        }

        memo[index][target] = dfs (nums, index+1, target - nums[index]) || dfs (nums, index+1, target);

        return memo[index][target];
    }
}
