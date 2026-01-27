class Solution {
    boolean[] vertical;
    boolean[] diagonal;
    boolean[] reverseDiagonal;

    public int totalNQueens(int n) {
        vertical = new boolean[n];
        diagonal = new boolean[(2*n)-1];
        reverseDiagonal = new boolean[(2*n)-1];

        return recursion(0, 0, n);
    }

    public int recursion(int i, int j, int n) {

        if (i == n) {
            return 1;
        }

        if (j == n) {
            return 0;
        }

        int counter = 0;
        
        counter += recursion(i, j+1, n);

        if (!vertical[j] && !diagonal[i+j] && !reverseDiagonal[i-j+n-1]) {
            vertical[j] = true;
            diagonal[i+j] = true;
            reverseDiagonal[i-j+n-1] = true;

            counter += recursion(i+1, 0, n);

            vertical[j] = false;
            diagonal[i+j] = false;
            reverseDiagonal[i-j+n-1] = false;
        }

        return counter;
    }
}