class Solution {
    Set<Character>[] rowSet;
    Set<Character>[] colSet;
    Set<Character>[][] matSet;

    public void solveSudoku(char[][] board) {
        
        rowSet = new HashSet[9];
        colSet = new HashSet[9];
        matSet = new HashSet[3][3];

        for (int i = 0; i < 9; i++ ) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
        }

        for (int i = 0; i < 3; i++ ) {
            for (int j = 0; j < 3; j++ ) {
                matSet[i][j] = new HashSet<>();
            }
        }
        
        for (int i = 0; i < 9; i++ ) {
            for (int j = 0; j < 9; j++ ) {
                if (board[i][j] != '.') {
                    rowSet[i].add(board[i][j]);
                    colSet[j].add(board[i][j]);
                    matSet[i/3][j/3].add(board[i][j]);
                }
            }
        }

        backtrack(board);
    }

    boolean backtrack(char[][] board) {
        for (int row = 0; row < 9; row++ ) {
            for (int column = 0; column < 9; column++ ) {
                if (board[row][column] == '.') {
                    for (char i = '1'; i <= '9'; i++ ) {
                        if (!rowSet[row].contains(i) && !colSet[column].contains(i) && !matSet[row/3][column/3].contains(i)) {
                            board[row][column] = i;
                            rowSet[row].add(i);
                            colSet[column].add(i);
                            matSet[row/3][column/3].add(i);
                            if (backtrack(board)) {
                                return true;
                            }
                            board[row][column] = '.';
                            rowSet[row].remove(i);
                            colSet[column].remove(i);
                            matSet[row/3][column/3].remove(i);
                        }
                    }
                    return false;
                }
            }
        }


        return true;
    }
}