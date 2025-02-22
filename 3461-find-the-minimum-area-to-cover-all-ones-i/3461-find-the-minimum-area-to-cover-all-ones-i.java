class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] row = new int[m];
        int[] col = new int[n];

        for (int i = 0; i < m; i++ ) {
            for (int j = 0; j < n; j++ ) {
                if (grid[i][j] == 1) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        int left = 0;
        int right = m-1;

        while (left < m && row[left] == 0) {
            left++;
        }

        while (right >= 0 && row[right] == 0) {
            right--;
        }

        int length = right - left + 1;
        if (length <= 0) return 0;

        left = 0;
        right = n-1;

        while (left < n && col[left] == 0) {
            left++;
        }

        while (right >= 0 && col[right] == 0) {
            right--;
        }

        int width = right - left + 1;
        if (width <= 0) return 0;

        return length * width;
        
    }
}