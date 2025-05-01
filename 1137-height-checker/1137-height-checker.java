class Solution {
    public int heightChecker(int[] heights) {
        int[] countSort = new int[101];
        int[] sortedArr = new int[heights.length];

        for (int height : heights) countSort[height]++;
        int index = 0;

        for (int i = 1; i < 101; i++ ) {
            while (countSort[i] > 0) {
                sortedArr[index++] = i;
                countSort[i]--;
            }
        }

        int result = 0;

        for (int i = 0; i < heights.length; i++ ) {
            if (heights[i] != sortedArr[i]) {
                result++;
            }
        }

        return result;
    }
}