class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] result = new int[n*m];

        int i = 0;
        int j = 0;
        int resultTracker = 0;

        boolean upwards = true;

        while (i < n && j < m && resultTracker != result.length) {
            if (upwards) {
                while (i >= 0 && j < m && resultTracker != result.length) {
                    result[resultTracker] = mat[i][j];
                    resultTracker++;
                    i--;
                    j++;
                }
                i++;
                if (j >= m) {
                    i++;
                    j = m-1;
                }
                upwards = false;

            } else {
                while (i < n && j >= 0 && resultTracker != result.length) {
                    result[resultTracker] = mat[i][j];
                    resultTracker++;
                    i++;
                    j--;
                }
                j++;
                if (i >= n) {
                    j++;
                    i = n-1;
                }
                upwards = true;
            }
        }

        return result;
    }
}