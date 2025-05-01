class Solution {
    int[][] memo;
    public int superEggDrop(int k, int n) {
        memo = new int[k+1][n+1];
        for (int[] mem : memo) {
            Arrays.fill(mem, -1);
        }

        return dfs (k, n);
    }

    int dfs (int k, int n) {
        
        if (n == 0 || n == 1) return n;
       
        // If we have only 1 egg, we check linearly for every floor. Max is n floors.
        if (k == 1) return n;

        if (memo[k][n] != -1) return memo[k][n];
        
        int l = 1, r = n, worstCase = 0, result = Integer.MAX_VALUE;
        
        while (l <= r) {
            int mid = l + (r - l) / 2;

            // Egg breaks: go below
            int breaks = dfs (k-1, mid-1);
            // Egg doesn't break: go above
            int survives = dfs (k, n-mid);

            worstCase = 1 + Math.max(breaks, survives);

            if (breaks < survives) {
                // Try higher floors
                l = mid + 1;
            } else {
                // Try lower floors
                r = mid - 1;
            }

            // Track minimum attempts
            result = Math.min(result, worstCase);
        }

        memo[k][n] = result;
        return result;
    }
}