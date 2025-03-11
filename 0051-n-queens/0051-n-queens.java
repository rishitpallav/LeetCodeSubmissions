class Solution {
    boolean[] row;
    boolean[] col;
    boolean[] leftDiagonal;
    boolean[] rightDiagonal;
    
    List<List<String>> result;
    
    public List<List<String>> solveNQueens(int n) {
        row = new boolean[n+1];
        col = new boolean[n+1];
        leftDiagonal = new boolean[n+n+1];
        rightDiagonal = new boolean[n+n+1];

        result = new ArrayList<>();

        backtrack(0, n, new int[n]);

        return result;
    }

    void backtrack(int row, int n, int[] previousJIndex) {
        if (row == n) {
            List<String> result = new ArrayList<>();
            for (int i : previousJIndex ) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++ ) {
                    sb.append(i == j ? "Q":".");
                }
                result.add(sb.toString());
            }
            this.result.add(result);
            return;
        }

        for (int col = 0; col < n; col++ ) {
            if (isValid(row, col, n)) {
                previousJIndex[row] = col;
                this.row[row] = true;
                this.col[col] = true;
                leftDiagonal[row + col] = true;
                rightDiagonal[col - row + n] = true;
                backtrack(row+1, n, previousJIndex);
                this.row[row] = false;
                this.col[col] = false;
                leftDiagonal[row + col] = false;
                rightDiagonal[col - row + n] = false;
            }
        }
    }

    boolean isValid(int i, int j, int n) {
        if (row[i]) return false;
        if (col[j]) return false;
        if (leftDiagonal[i+j]) return false;
        if (rightDiagonal[j-i+n]) return false;

        return true;
    }
}
