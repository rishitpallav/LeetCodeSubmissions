class Solution {
    public int uniquePaths(int m, int n) {
        int[] board = new int[n];
        
        Arrays.fill(board, 1);

        for (int i = 1; i < m; i++ ) {
            for (int j = 1; j < n; j++ ) {
                board[j] += board[j-1];
            }
        }

        return board[n-1];
    }
}