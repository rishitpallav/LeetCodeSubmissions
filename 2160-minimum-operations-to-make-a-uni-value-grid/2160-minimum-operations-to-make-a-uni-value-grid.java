class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> allElements = new ArrayList<>();

        for (int i = 0; i < grid.length; i++ ) {
            for (int j = 0; j < grid[0].length; j++ ) {
                allElements.add(grid[i][j]);
            }
        }

        Collections.sort(allElements);

        int median = allElements.get(allElements.size() / 2);
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