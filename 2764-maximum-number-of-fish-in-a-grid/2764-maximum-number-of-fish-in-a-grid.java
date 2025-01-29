class Solution {
    public int findMaxFish(int[][] grid) {
        int max = 0;

        for (int i = 0; i < grid.length; i++ ) {
            for (int j = 0; j < grid[0].length; j++ ) {
                if (grid[i][j] > 0) {
                    max = Math.max(max, totalDfs(new int[]{i,j}, grid, new boolean[grid.length][grid[0].length]));
                }
            }
        }

        return max;
    }

    int totalDfs(int[] current, int[][] grid, boolean[][] visited) {
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        int total = grid[current[0]][current[1]];
        visited[current[0]][current[1]] = true;
        
        for (int[] d : directions) {
            int x = current[0] + d[0];
            int y = current[1] + d[1];

            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] > 0 && !visited[x][y]) {
                total += totalDfs(new int[]{x, y}, grid, visited);
            }

        }
        grid[current[0]][current[1]] = 0;

        return total;
    }
}