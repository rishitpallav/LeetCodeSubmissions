class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> bfs = new LinkedList<>();

        int freshCount = 0;

        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++ ) {
            for (int j = 0; j < m; j++ ) {
                if (grid[i][j] == 2) {
                    bfs.add(new int[]{i,j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0;

        int time = -1;

        while (!bfs.isEmpty()) {
            time++;

            Queue<int[]> next = new LinkedList<>();
            int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

            while (!bfs.isEmpty()) {
                int[] rotten = bfs.poll();
                for (int[] direction : directions) {
                    int newI = direction[0] + rotten[0];
                    int newJ = direction[1] + rotten[1];
                    if (newI >= 0 && newJ >= 0 && newI < n && newJ < m && grid[newI][newJ] == 1) {
                        grid[newI][newJ] = 2;
                        freshCount--;
                        next.add(new int[]{newI, newJ});
                    }
                }
            }

            bfs = next;
        }


        return (freshCount == 0) ? time : -1;
    }
}
