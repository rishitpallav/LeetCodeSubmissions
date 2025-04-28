class Solution {
    int[][] directions = new int[][]{{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}};
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] memo = new double[n][n][k+1];
        
        for (double[][] me : memo) {
            for (double[] m : me) {
                Arrays.fill(m, -1.0);
            }
        }
        
        return dfs (n, k, row, column, memo);
    }

    double dfs(int n, int k, int row, int column, double[][][] memo) {
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0.0f;
        }

        if (k == 0) {
            return 1.0f;
        }

        if (memo[row][column][k] != -1.0) {
            return memo[row][column][k];
        }


        double probability = 0.0f;
        for (int[] d : directions) {
            probability += (dfs(n, k-1, row + d[0], column + d[1], memo) / 8);
        }
        
        memo[row][column][k] = probability;

        return probability;
    }
}