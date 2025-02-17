class Solution {
    Set<Integer>[] rowSet;
    Set<Integer>[] colSet;
    Set<Integer>[][] matSet;

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
                    int temp = board[i][j] - '0';
                    rowSet[i].add(temp);
                    colSet[j].add(temp);
                    matSet[i/3][j/3].add(temp);
                }
            }
        }

        backtrack(board);
    }

    boolean backtrack(char[][] board) {
        int row = -1, column = -1;
        OUTER:
        for (int i = 0; i < 9; i++ ) {
            for (int j = 0; j < 9; j++ ) {
                if (board[i][j] == '.') {
                    row = i;
                    column = j;
                    break OUTER;
                }
            }
        }

        if (row == -1 && column == -1) {
            return true;
        }

        for (int i = 1; i <= 9; i++ ) {
            if (!rowSet[row].contains(i) && !colSet[column].contains(i) && !matSet[row/3][column/3].contains(i)) {
                board[row][column] = (char) ('0' + i);
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