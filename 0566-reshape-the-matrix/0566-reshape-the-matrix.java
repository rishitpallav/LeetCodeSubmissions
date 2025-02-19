class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int m = mat.length, n = mat[0].length;
        
        if (r * c != m * n) {
            return mat;
        }
        
        int[][] res = new int[r][c];

        int x = 0, y = 0;

        for (int i = 0; i < m; i++ ) {
            for (int j = 0; j < n; j++ ) {
                res[x][y++] = mat[i][j];
                if (y == c) {
                    y = 0;
                    x++;
                }
            }
        }

        return res;
    }
}