class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        
        for (int i = 1; i < n; i++ ) {
            for (int j = 0; j < m; j++ ) {
                int min = Integer.MAX_VALUE;
                for (int k = -1; k < 2; k++ ) {
                    int x = i-1, y = j + k;
                    if (x >= 0 && x < n && y >= 0 && y < m) {
                        min = Math.min(min, matrix[x][y]);
                    }
                }
                matrix[i][j] += min;
            }
        }

        int min = Integer.MAX_VALUE;

        for (int j = 0; j < m; j++ ) {
            min = Math.min(matrix[n-1][j], min);
        }

        return min;
    }
}