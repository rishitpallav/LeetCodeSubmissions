class Solution {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        memo = new int[amount+1];
        Arrays.fill(memo, -1);
        memo[0] = 0;

        int result = getMinimumCoins(coins, amount);

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    int getMinimumCoins(int[] coins, int amount) {
        if (memo[amount] != -1) {
            return memo[amount];
        }

        int minimum = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++ ) {
            if (amount >= coins[i]) {
                int nextCoins = getMinimumCoins(coins, amount - coins[i]);
                if (nextCoins != Integer.MAX_VALUE) {
                    minimum = Math.min(minimum, nextCoins + 1);
                }
            }
        }

        memo[amount] = minimum;
        return memo[amount];
    }
}