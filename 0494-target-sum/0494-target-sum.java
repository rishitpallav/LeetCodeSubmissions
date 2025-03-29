class Solution {
    int[][] memo;
    int offset;
    public int findTargetSumWays(int[] nums, int target) {
        offset = 0;
        for (int num : nums) offset += num;
        memo = new int[nums.length][2 * offset + 1];

        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        return dfs (nums, 0, 0, target);
    }

    int dfs (int[] nums, int index, int current, int target) {
        if (index == nums.length) {
            return current == target ? 1 : 0;
        }

        if (memo[index][current + offset] != -1) {
            return memo[index][current + offset];
        }

        memo[index][current + offset] = dfs (nums, index+1, current - nums[index], target) + 
            dfs (nums, index+1, current + nums[index], target);

        return memo[index][current + offset];
    }
}
