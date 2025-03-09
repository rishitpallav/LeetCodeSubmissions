class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++ ) {
            for (int j = 0; j < board[0].length; j++ ) {
                if (board[i][j] == word.charAt(0)) {
                    if (checkWord(board, i, j, word, 1, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    boolean checkWord(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }


        visited[i][j] = true;

        boolean result =
        (i < board.length -1 && !visited[i+1][j] && board[i+1][j] == word.charAt(index) && checkWord(board, i+1, j, word, index+1, visited)) || 
        (j < board[0].length - 1 && !visited[i][j+1] && board[i][j+1] == word.charAt(index) && checkWord(board, i, j+1, word, index+1, visited)) || 
        (i > 0 && !visited[i-1][j] && board[i-1][j] == word.charAt(index) && checkWord(board, i-1, j, word, index+1, visited)) || 
        (j > 0 && !visited[i][j-1] && board[i][j-1] == word.charAt(index) && checkWord(board, i, j-1, word, index+1, visited));

        visited[i][j] = false;

        return result;
    }
}
