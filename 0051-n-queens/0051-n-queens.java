class Solution {

    int[][] board;
    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        board = new int[n][n];
        result = new ArrayList<>();

        findQueens(n, 0);

        return result;
    }

    void findQueens(int n, int index) {
        if (index == n) {
            List<String> res = new ArrayList<>();

            for (int[] i : board) {
                StringBuilder sb = new StringBuilder();
                for (int j : i) {
                    sb.append(j==0?".":"Q");
                }
                res.add(sb.toString());
            }
            result.add(res);

            return;
        }

        for (int j = 0; j < n; j++ ) {
            if (board[index][j] == 0) {
                if (checkValidity(index, j, n)) {
                    board[index][j] = 1;
                    findQueens(n, index+1);
                    board[index][j] = 0;
                }
            }
        }
    }

    boolean checkValidity(int row, int column, int n) {
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

        for (int i = row, j = column; i >= 0; i-- ) {
            if (board[i][j] == 1) return false;
        }

        for (int i = row, j = column; i < n; i++ ) {
            if (board[i][j] == 1) return false;
        }

        for (int i = row, j = column; j >= 0; j-- ) {
            if (board[i][j] == 1) return false;
        }

        for (int i = row, j = column; j < n; j++ ) {
            if (board[i][j] == 1) return false;
        }

        return true;
    }
}