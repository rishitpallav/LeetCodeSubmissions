class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++ ) {
            for (int j = 0; j < m; j++ ) {
                if (board[i][j] == 'O') {
                    if (!visited[i][j] && dfs(board, i, j, visited)) {
                        makeWater(board, i, j);
                    }
                }
            }
        }
    }

    void makeWater(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X') {
            return;
        }

        board[i][j] = 'X';

        makeWater(board, i+1, j);
        makeWater(board, i-1, j);
        makeWater(board, i, j+1);
        makeWater(board, i, j-1);
    }

    boolean dfs(char[][] board, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }

        if (visited[i][j]) return true;

        if (board[i][j] == 'X') {
            return true;
        }

        visited[i][j] = true;

        int[][] directions = {{0,-1},{0,1},{1,0},{-1,0}};

        boolean isSurrounded = true;

        for (int[] d : directions) {
            int newI = i + d[0];
            int newJ = j + d[1];
            isSurrounded &= dfs(board, newI, newJ, visited);
        }

        return isSurrounded;

    }
}
