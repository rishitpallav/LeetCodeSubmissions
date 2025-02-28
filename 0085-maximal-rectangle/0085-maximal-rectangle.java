class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxRectangle = 0;

        int[] lengths = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++ ) {
            for (int j = 0; j < matrix[0].length; j++ ) {
                if (matrix[i][j] == '0') {
                    lengths[j] = 0;
                } else {
                    lengths[j] += 1;
                }
            }
            System.out.println(Arrays.toString(lengths));
            maxRectangle = Math.max(maxRectangle, largestRectangleArea(lengths));
            System.out.println(maxRectangle);
        }

        return maxRectangle;
    }

    int largestRectangleArea(int[] lengths) {
        Stack<int[]> stack = new Stack<>();

        int result = 0;

        for (int i = 0; i < lengths.length; i++ ) {
            int start = i;

            while (!stack.empty() && stack.peek()[0] > lengths[i]) {
                int[] current = stack.pop();
                result = Math.max(result, (i - current[1]) * current[0]);
                start = current[1];
            }
            stack.push(new int[]{lengths[i], start});
        }

        while (!stack.empty()) {
            int[] current = stack.pop();
            result = Math.max(result, (lengths.length - current[1]) * current[0]);
        }

        return result;
    }
}