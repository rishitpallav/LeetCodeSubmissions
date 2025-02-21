class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int total = 0;
        int n = grid.length;

        int[] row = new int[n];
        int[] col = new int[n];

        for (int i = 0; i < n; i++ ) {
            for (int j = 0; j < n; j++ ) {
                row[i] = Math.max(row[i], grid[i][j]);
                col[j] = Math.max(col[j], grid[i][j]);
            }
        }

        for (int i = 0; i < n; i++ ) {
            for (int j = 0; j < n; j++ ) {
                total += (Math.min(row[i], col[j]) - grid[i][j]);
            }
        }

        return total;
    }
}