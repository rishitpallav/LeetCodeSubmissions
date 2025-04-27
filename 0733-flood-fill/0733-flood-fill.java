class Solution {

    class Pair {
        int a;
        int b;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if (image[sr][sc] == color) return image;

        Queue<Pair> bfs = new LinkedList<>();
        int previousColor = image[sr][sc];

        bfs.add(new Pair(sr, sc));
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int n = image.length, m = image[0].length;
        image[sr][sc] = color;

        while (!bfs.isEmpty()) {
            Pair currentPair = bfs.poll();

            for (int[] d : directions) {
                int new_x = d[0] + currentPair.a, new_y = d[1] + currentPair.b;
                if (new_x >= 0 && new_x < n && new_y >= 0 && new_y < m && image[new_x][new_y] == previousColor) {
                    image[new_x][new_y] = color;
                    bfs.add(new Pair(new_x, new_y));
                }
            }
        }

        return image;
    }
}