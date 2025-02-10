class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if (image[sr][sc] == color) {
            return image;
        }

        Queue<int[]> connectedCells = new LinkedList<>();
        connectedCells.add(new int[]{sr,sc});

        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int n = image.length;
        int m = image[0].length;

        int sourceColor = image[sr][sc];

        while (!connectedCells.isEmpty()) {
            int[] cell = connectedCells.poll();
            image[cell[0]][cell[1]] = color;
            for (int[] d : directions) {
                int i = cell[0] + d[0];
                int j = cell[1] + d[1];

                if (i >= 0 && j >= 0 && i < n && j < m && image[i][j] == sourceColor) {
                    connectedCells.add(new int[]{i,j});
                }
            }
        }

        return image;
    }
}