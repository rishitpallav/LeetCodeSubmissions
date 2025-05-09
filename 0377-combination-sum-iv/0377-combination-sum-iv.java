class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target+1];
        Arrays.fill(memo, -1);
        return dfs (nums, target, memo);
    }

    int dfs (int[] nums, int target, int[] memo) {
        if (memo[target] != -1) {
            return memo[target];
        }

        int total = 0;

        for (int num : nums) {
            if (target - num == 0) {
                total++;
            } else if (target - num > 0) {
                total += dfs (nums, target - num, memo);
            }
        }

        memo[target] = total;
        return total;
    }
}