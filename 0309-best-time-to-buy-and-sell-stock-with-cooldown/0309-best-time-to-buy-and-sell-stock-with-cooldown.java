class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 0 for not holding a stock, 1 for holding a stock
        dp = new int[n][2];
        for (int[] row : dp) Arrays.fill(row, Integer.MIN_VALUE);
        int result = findMaxProfit (prices, 0, 0);

        return result > 0 ? result : 0;
    }

    int findMaxProfit (int[] prices, int index, int action) {
        if (index >= prices.length) {
            return 0;
        }
        
        if (dp[index][action] != Integer.MIN_VALUE) {
            return dp[index][action];
        }

        if (action == 0) {
            dp[index][action] = Math.max(
                // skip and not buy current
                findMaxProfit(prices, index+1, action),
                // buy current
                findMaxProfit(prices, index+1, 1) - prices[index]
            );
        } else {
            dp[index][action] = Math.max (
                // hold current stock
                findMaxProfit(prices, index+1, action),
                // if stock is profitable, sell it
                findMaxProfit(prices, index+2, 0) + prices[index]
            );
        }
        return dp[index][action];
    }
}
