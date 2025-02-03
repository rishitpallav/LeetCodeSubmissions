class Solution {
    int[][] directions = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
    int n, m;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int counter = 0;
        n = grid1.length;
        m = grid1[0].length;

        for (int i = 0; i < n; i++ ) {
            for (int j = 0; j < m; j++ ) {
                if (grid2[i][j] == 1 && grid1[i][j] == 1) {
                    if (checkValid(grid1, grid2, i, j)) {
                        counter++;
                    }
                }
            }
        }

        return counter;
    }

    public boolean checkValid(int[][] grid1, int[][] grid2, int i, int j) {

        grid2[i][j] = -1;

        boolean result = grid1[i][j] == 1;

        for (int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];

            if (newI >= 0 && newI < n && newJ >= 0 && newJ < m && grid2[newI][newJ] == 1) {
                result &= checkValid(grid1, grid2, newI, newJ);
            }
        }

        return result;
    }
}