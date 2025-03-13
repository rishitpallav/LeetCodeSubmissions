class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++ ) {
            if(board[i][0] == 'O') {
                makeLand(board, i, 0);
            }
            if (board[i][m-1] == 'O') {
                makeLand(board, i, m-1);
            }
        }

        for (int j = 0; j < m; j++ ) {
            if (board[0][j] == 'O') {
                makeLand(board, 0, j);
            }
            if (board[n-1][j] == 'O') {
                makeLand(board, n-1, j);
            }
        }

        for (int i = 0; i < n; i++ ) {
            for (int j = 0; j < m; j++ ) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'P') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    void makeLand(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'P' || board[i][j] == 'X') {
            return;
        }

        board[i][j] = 'P';

        makeLand(board, i+1, j);
        makeLand(board, i-1, j);
        makeLand(board, i, j+1);
        makeLand(board, i, j-1);
    }
}