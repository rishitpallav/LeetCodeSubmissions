class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int top = 0;
        int bottom = n-1;

        while (top <= bottom) {

            int mid = top + (bottom - top)/2;

            if (target < matrix[mid][0]) {
                bottom = mid - 1;
            } else if (target > matrix[mid][m-1]) {
                top = mid + 1;
            } else {
                break;
            }
        }

        if (!(top <= bottom)) {
            return false;
        }

        int row = top + (bottom - top)/2;
        int left = 0;
        int right = m-1;

        while (left <= right) {
            int innerMid = left + ((right - left)/2);

            if (target < matrix[row][innerMid]) {
                right = innerMid - 1;
            } else if (target > matrix[row][innerMid]) {
                left = innerMid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}