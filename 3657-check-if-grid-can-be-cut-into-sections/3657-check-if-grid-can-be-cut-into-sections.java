class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        Arrays.sort(rectangles, (a, b) -> a[0] - b[0]);

        int cuts = 0;
        int previousLargest = rectangles[0][2];

        for (int[] rectangle : rectangles) {
            if (previousLargest <= rectangle[0]) {
                cuts++;
            }
            previousLargest = Math.max(previousLargest, rectangle[2]);
        }

        if (cuts >= 2) return true;



        Arrays.sort(rectangles, (a, b) -> a[1] - b[1]);

        cuts = 0;
        previousLargest = rectangles[0][3];

        for (int[] rectangle : rectangles) {
            if (previousLargest <= rectangle[1]) {
                cuts++;
            }
            previousLargest = Math.max(previousLargest, rectangle[3]);
        }

        if (cuts >= 2) return true;

        return false;
    }
}