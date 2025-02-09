class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        Queue<int[]> clicks = new LinkedList<>();
        clicks.add(click);

        int[][] directions = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

        while (!clicks.isEmpty()) {
            int[] temp = clicks.poll();
            int surroundingBombs = 0;
            List<int[]> potentialCells = new ArrayList<>();

            for (int[] direction : directions) {
                int i = direction[0] + temp[0];
                int j = direction[1] + temp[1];

                if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == 'M') {
                    surroundingBombs++;
                }
            }

            if (surroundingBombs > 0) {
                board[temp[0]][temp[1]] = (char) ('0' + surroundingBombs);
            } else {
                board[temp[0]][temp[1]] = 'B';

                for (int[] direction : directions) {
                    int i = direction[0] + temp[0];
                    int j = direction[1] + temp[1];

                    if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == 'E') {
                        board[i][j] = 'B';
                        clicks.add(new int[]{i,j});
                    }
                }
            }
        }

        return board;
    }
}