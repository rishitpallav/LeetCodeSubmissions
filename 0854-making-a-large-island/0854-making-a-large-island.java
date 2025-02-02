class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int islandNumber = -1;
        int[][] islandTotal = new int[n][m];
        
        for (int i = 0; i < n; i++ ) {
            for (int j = 0; j < m; j++ ) {
                if (grid[i][j] == 1) {
                    ArrayList<int[]> travelledIslands = new ArrayList<>();
                    grid[i][j] = islandNumber;
                    int sum = getConnectedIslandsSum(i, j, grid, travelledIslands, islandNumber);
                    for (int[] island : travelledIslands) {
                        islandTotal[island[0]][island[1]] = sum;
                    }
                    islandTotal[i][j] = sum;
                    islandNumber--;
                }
            }
        }

        int result = islandTotal[0][0];

        int[][] directions = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
        for (int i = 0; i < n; i++ ) {
            for (int j = 0; j < m; j++ ) {
                if (grid[i][j] == 0) {
                    int sum = 0;
                    Set<Integer> includedCoordinates = new HashSet<>();
                    for (int[] direction : directions ) {
                        int newI = i + direction[0];
                        int newJ = j + direction[1];

                        if (newI >= 0 && newI  < n && newJ >= 0 && newJ < m && !includedCoordinates.contains(grid[newI][newJ])) {
                            sum += islandTotal[newI][newJ];
                            includedCoordinates.add(grid[newI][newJ]);
                        }
                    }
                    result = Math.max(result, sum+1);
                }
            }
        }

        
        return result;
    }
    public int getConnectedIslandsSum(int i, int j, int[][] grid, ArrayList<int[]> travelledIslands, int islandNumber) {
        int[][] directions = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};

        int sum = 1;

        for(int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];

            if (newI >= 0 && newI < grid.length && newJ >= 0 && newJ < grid[0].length && grid[newI][newJ] == 1) {
                travelledIslands.add(new int[]{newI, newJ});
                grid[newI][newJ] = islandNumber;
                sum += getConnectedIslandsSum(newI, newJ, grid, travelledIslands, islandNumber);
            }
        }

        return sum;
    }
}