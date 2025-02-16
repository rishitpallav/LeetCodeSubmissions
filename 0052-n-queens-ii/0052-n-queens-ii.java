class Solution {

    int[][] board;
    int result;
    boolean[] columnFilled;

    public int totalNQueens(int n) {
        board = new int[n][n];
        result = 0;
        columnFilled = new boolean[n];

        findQueens(n, 0);

        return result;
    }

    void findQueens(int n, int index) {
        if (index == n) {
            result++;
            return;
        }

        for (int j = 0; j < n; j++ ) {
            if (board[index][j] == 0) {
                if (checkValidity(index, j, n)) {
                    board[index][j] = 1;
                    columnFilled[j] = true;
                    findQueens(n, index+1);
                    board[index][j] = 0;
                    columnFilled[j] = false;
                }
            }
        }
    }

    boolean checkValidity(int row, int column, int n) {

        if (columnFilled[column]) {
            return false;
        }
        
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j-- ) {
            if (board[i][j] == 1) return false;
        }

        for (int i = row, j = column; i >= 0 && j < n; i--, j++ ) {
            if (board[i][j] == 1) return false;
        }

        for (int i = row, j = column; i < n && j >= 0; i++, j-- ) {
            if (board[i][j] == 1) return false;
        }

        for (int i = row, j = column; i < n && j < n; i++, j++ ) {
            if (board[i][j] == 1) return false;
        }

        return true;
    }
}