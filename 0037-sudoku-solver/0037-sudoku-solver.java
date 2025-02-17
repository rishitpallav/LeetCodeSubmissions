class Solution {
    boolean[][] rowSet;
    boolean[][] colSet;
    boolean[][][] matSet;

    public void solveSudoku(char[][] board) {
        
        rowSet = new boolean[9][10];
        colSet = new boolean[9][10];
        matSet = new boolean[3][3][10];

        for (int i = 0; i < 9; i++ ) {
            for (int j = 0; j < 9; j++ ) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    rowSet[i][num] = true;
                    colSet[j][num] = true;
                    matSet[i/3][j/3][num] = true;
                }
            }
        }

        backtrack(board);
    }

    boolean backtrack(char[][] board) {
        for (int row = 0; row < 9; row++ ) {
            for (int column = 0; column < 9; column++ ) {
                if (board[row][column] == '.') {
                    for (char i = 1; i <= 9; i++ ) {
                        if (!rowSet[row][i] && !colSet[column][i] && !matSet[row/3][column/3][i]) {
                            board[row][column] = (char) (i+'0');
                            rowSet[row][i] = true;
                            colSet[column][i] = true;
                            matSet[row/3][column/3][i] = true;
                            if (backtrack(board)) {
                                return true;
                            }
                            board[row][column] = '.';
                            rowSet[row][i] = false;
                            colSet[column][i] = false;
                            matSet[row/3][column/3][i] = false;
                        }
                    }
                    return false;
                }
            }
        }


        return true;
    }
}