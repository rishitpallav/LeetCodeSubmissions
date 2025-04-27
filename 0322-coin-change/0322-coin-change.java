class Solution {
    Map<Integer, Integer> memo;
    public int coinChange(int[] coins, int amount) {
        memo = new HashMap<>();
        memo.put(0, 0);

        int result = dfs (coins, amount);

        return (result == Integer.MAX_VALUE) ? -1 : result;
    }

    int dfs (int[] coins, int amount) {
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        int res = Integer.MAX_VALUE;

        for (int coin : coins) {
            if (amount - coin >= 0) {
                int temp = dfs(coins, amount - coin);
                if (temp != Integer.MAX_VALUE) {
                    res = Math.min(res, temp + 1);
                }
            }
        }

        memo.put(amount, res);
        return res;
    }
}
