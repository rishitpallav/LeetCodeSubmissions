class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] memo = new double[n][n][k+1];

        for (double[][] x : memo) {
            for (double[] y : x) {
                Arrays.fill(y,-1.0);
            }
        }

        return knightProbability(n, k, row, column, memo);
    }

    double knightProbability(int n, int k, int i, int j, double[][][] memo) {
        if (i < 0 || j < 0 || i >= n || j >= n) {
            return 0.0f;
        }
        if (k == 0) {
            return 1.0f;
        }
        if (memo[i][j][k] > -1) {
            return memo[i][j][k];
        }
        int[][] directions = new int[][]{{-1,-2},{-2,-1},{-2,1},{-1,2},{1,-2},{2,-1},{2,1},{1,2}};
        double timesOutside = 0.0f;

        for (int[] d : directions) {
            timesOutside += knightProbability(n, k-1, i+d[0], j+d[1], memo);
        }

        memo[i][j][k] = timesOutside/8;

        return memo[i][j][k];
    }
}