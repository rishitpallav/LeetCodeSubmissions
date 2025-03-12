class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        int n = heights.length, m = heights[0].length;
        
        boolean[][] pacificOcean = new boolean[n][m];
        boolean[][] atlanticOcean = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++ ) {
            queue.add(new int[]{i, 0});
            pacificOcean[i][0] = true;
            queue.add(new int[]{i, m-1});
            atlanticOcean[i][m-1] = true;
        }

        for (int j = 0; j < m; j++ ) {
            queue.add(new int[]{0, j});
            pacificOcean[0][j] = true;
            queue.add(new int[]{n-1, j});
            atlanticOcean[n-1][j] = true;
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int[] d : directions) {
                int i = current[0] + d[0];
                int j = current[1] + d[1];

                if (i > -1 && j > -1 && i < n && j < m && (atlanticOcean[current[0]][current[1]] && !atlanticOcean[i][j] || pacificOcean[current[0]][current[1]] && !pacificOcean[i][j]) && heights[current[0]][current[1]] <= heights[i][j]) {
                    queue.add(new int[]{i,j});
                    if (atlanticOcean[current[0]][current[1]]) atlanticOcean[i][j] = true;
                    if (pacificOcean[current[0]][current[1]]) pacificOcean[i][j] = true;
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++ ) {
            for (int j = 0; j < m; j++ ) {
                if (pacificOcean[i][j] && atlanticOcean[i][j]) {
                    List<Integer> res = new ArrayList<>();
                    res.add(i);res.add(j);
                    result.add(res);
                }
            }
        }

        return result;
    }
}
