class Solution {
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++ ) {
            for (int j = 0; j < grid[0].length; j++ ) {
                if (grid[i][j] == 1) {
                    return findPerimeterOfIsland(grid, i, j, new boolean[grid.length][grid[0].length]);
                }
            }
        }

        return 0;
    }

    int findPerimeterOfIsland(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 1;
        }

        if (visited[i][j]) return 0;

        int total = 0;

        visited[i][j] = true;

        total += findPerimeterOfIsland(grid, i+1, j, visited) + 
            findPerimeterOfIsland(grid, i-1, j, visited) +
            findPerimeterOfIsland(grid, i, j+1, visited) +
            findPerimeterOfIsland(grid, i, j-1, visited);
        return total;
    }
}