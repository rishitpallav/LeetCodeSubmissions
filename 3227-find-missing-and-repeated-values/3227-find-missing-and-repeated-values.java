class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length;

        int[] map = new int[(n*n) + 1];

        int repeated = 0;
        int sum = 0;

        for (int i = 0; i < n; i++ ) {
            for (int j = 0; j < grid[0].length; j++ ) {
                if (map[grid[i][j]] == 1) {
                    repeated = grid[i][j];
                } else {
                    sum += grid[i][j];
                    map[grid[i][j]]++;
                }
            }
        }

        return new int[]{repeated, ((n*n*(n*n+1))/2) - sum};
    }
}