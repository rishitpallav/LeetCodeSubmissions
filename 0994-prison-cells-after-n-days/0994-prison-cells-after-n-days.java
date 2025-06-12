class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        if (n == 0) return cells;

        int[] result = performCalculation(cells);
        n--;
        n %= 14;

        while (n-- > 0) {
            result = performCalculation(result);
        }

        return result;
    }

    int[] performCalculation(int[] cells) {
        int[] temp = new int[8];
        for (int i = 1; i < 7; i++ ) {
            temp[i] = (cells[i-1] == cells[i+1]) ? 1 : 0;
        }
        return temp;
    }
}