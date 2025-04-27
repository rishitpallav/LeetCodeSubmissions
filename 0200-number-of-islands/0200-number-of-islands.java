class Solution {
    
    int[][] directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public int numIslands(char[][] grid) {
        int countIslands = 0;

        for (int i = 0; i < grid.length; i++ ) {
            for (int j = 0; j < grid[0].length; j++ ) {
                if (grid[i][j] == '1') {
                    countIslands++;
                    markIslands(grid, i, j);
                }
            }
        }

        return countIslands;
    }

    void markIslands(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1') {
            return;
        }
        grid[x][y] = '2';
        for (int[] d : directions) {
            int newX = d[0] + x;
            int newY = d[1] + y;
            markIslands(grid, newX, newY);
        }
    }
}