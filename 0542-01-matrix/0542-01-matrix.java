class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;

        int[][] result = new int[n][m];
        for (int[] x : result) Arrays.fill(x, -1);

        Queue<int[]> bfs = new LinkedList<>();

        for (int i = 0; i < n; i++ ) {
            for (int j = 0; j < m; j++ ) {
                if (mat[i][j] == 0) {
                    bfs.add(new int[]{i,j});
                    result[i][j] = 0;
                }
            }
        }

        int distance = 1;
        int[][] directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

        while (!bfs.isEmpty()) {
            int size = bfs.size();

            while (size-- > 0) {
                int[] current = bfs.poll();

                for (int[] d : directions) {
                    int newI = current[0] + d[0];
                    int newJ = current[1] + d[1];

                    if (newI >= 0 && newJ >= 0 && newI < n && newJ < m && result[newI][newJ] == -1) {
                        result[newI][newJ] = distance;

                        bfs.add(new int[]{newI, newJ});
                    }
                }
            }

            distance++;
        }

        return result;
    }
}