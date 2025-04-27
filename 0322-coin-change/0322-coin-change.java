class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        memo.put(0,0);
        int result = dfs(coins, amount);
        return result == Integer.MAX_VALUE?-1:result;
    }

    int dfs(int[] coins, int required) {
        if (memo.containsKey(required)) {
            return memo.get(required);
        }

        int minimum = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++ ) {
            if (required >= coins[i]) {
                int levels = dfs(coins, required - coins[i]);
                if (levels != Integer.MAX_VALUE) {
                    minimum = Math.min(minimum, 1 + levels);
                }
            }
        }

        memo.put(required, minimum);

        return minimum;
    }
}