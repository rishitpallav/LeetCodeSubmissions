class Solution {
    public int[][] generateMatrix(int n) {

        int[][] result = new int[n][n];

        for (int i = 1; i <= n; i++) {
            result[0][i-1] = i;
        }

        int i = 1;
        int j = n-1;
        int duration = n-1;
        int direction = 0;
        int repeat = 2;
        int number = n+1;

        while (duration > 0) {
            if (repeat == 0) {
                duration--;
                repeat = 2;
            }
            if (direction == 0) {
                for (int insert = 0; insert < duration; insert++) {
                    result[i][j] = number;
                    number++;
                    i++;
                }
                i--;
                j--;
            }
            else if (direction == 1) {
                for (int insert = 0; insert < duration; insert++) {
                    result[i][j] = number;
                    number++;
                    j--;
                }
                j++;
                i--;
            }
            else if (direction == 2) {
                for (int insert = 0; insert < duration; insert++) {
                    result[i][j] = number;
                    number++;
                    i--;
                }
                i++;
                j++;
            }
            else if (direction == 3) {
                for (int insert = 0; insert < duration; insert++) {
                    result[i][j] = number;
                    number++;
                    j++;
                }
                j--;
                i++;
            }
            direction = (direction+1)%4;
            repeat--;
        }
        return result;
    }
}