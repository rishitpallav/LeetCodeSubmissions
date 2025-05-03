/*

        [1,0,7,0,0,0],
        [2,0,6,0,1,0],
        [3,5,6,7,4,2],
        [4,3,1,0,2,0],
        [3,0,5,0,20,0]
*/


class Solution {
    public int getMaximumGold(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++ ) {
            for (int j = 0; j < grid[0].length; j++ ) {
                result = Math.max(result, getMaxGold(grid, i, j));
            }
        }

        return result;
    }

    int getMaxGold(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        int temp = grid[i][j];
        grid[i][j] = 0;

        int max = Math.max (
            getMaxGold(grid, i-1, j),
            Math.max (
                getMaxGold(grid, i+1, j),
                Math.max (
                    getMaxGold(grid, i, j-1),
                    getMaxGold(grid, i, j+1)
                )
            )
        );

        grid[i][j] = temp;

        return max + temp;
    }
}