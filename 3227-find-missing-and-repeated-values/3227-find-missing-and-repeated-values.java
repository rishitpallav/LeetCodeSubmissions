class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] map = new int[(grid.length*grid.length) + 1];

        for (int i = 0; i < grid.length; i++ ) {
            for (int j = 0; j < grid[0].length; j++ ) {
                map[grid[i][j]]++;
            }
        }

        int repeated = 0;
        int notPresent = 0;

        for (int i = 0; i < map.length; i++ ) {
            if (map[i] == 0)
                notPresent = i;
            else if (map[i] == 2)
                repeated = i;
        }

        return new int[]{repeated, notPresent};
    }
}