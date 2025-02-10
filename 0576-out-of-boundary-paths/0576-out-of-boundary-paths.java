class Solution {
    int M = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] memo = new int[m][n][maxMove + 1];

        for (int[][] x : memo) {
            for (int[] y : x) {
                Arrays.fill(y, -1);
            }
        }

        return findPaths(m, n, maxMove, startRow, startColumn, memo);
    }

    int findPaths(int m, int n, int maxMove, int i, int j, int[][][] memo) {
        if (i < 0 || j < 0 || i == m || j == n) {
            return 1;
        }
        if (maxMove == 0) {
            return 0;
        }
        if (memo[i][j][maxMove] > -1) {
            return memo[i][j][maxMove];
        }

        // Approach 1:

        int[][] directions = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
        int total = 0;

        for (int[] d : directions) {
            total = (total + findPaths(m,n,maxMove-1,i+d[0],j+d[1],memo))%M;
        }
        memo[i][j][maxMove] = total;

        return memo[i][j][maxMove];
    }
}