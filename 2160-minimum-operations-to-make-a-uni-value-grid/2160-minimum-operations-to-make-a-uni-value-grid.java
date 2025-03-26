class Solution {
    public int minOperations(int[][] grid, int x) {
        int[] allElements = new int[grid[0].length * grid.length];
        int index = 0;

        for (int i = 0; i < grid.length; i++ ) {
            for (int j = 0; j < grid[0].length; j++ ) {
                allElements[index++] = grid[i][j];
            }
        }

        Arrays.sort(allElements);

        int median = allElements[allElements.length / 2];
        int total = 0;

        for (int element : allElements ) {
            int difference = Math.abs (median - element);

            if (element % x != median % x) {
                return -1;
            }
            total += difference / x;
        }

        return total;
    }
}