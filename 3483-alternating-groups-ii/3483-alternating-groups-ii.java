class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        boolean[] col = new boolean[colors.length];

        for (int i = 0; i < colors.length-1; i++ ) {
            if (colors[i] != colors[i+1]) {
                col[i] = true;
            }
        }

        col[colors.length - 1] = colors[colors.length - 1] != colors[0];

        int result = 0;
        int countTrue = 0;

        for (int index = 0; index < col.length-1 + k; index++ ) {
            int i = index % col.length;
            if (!col[i]) {
                if (countTrue + 1 >= k) {
                    result += (countTrue - k + 1) + 1;
                }
                countTrue = 0;
            } else {
                countTrue++;
            }
        }

        if (countTrue + 1 >= k) {
            result += (countTrue - k + 1);
        }

        return result;
    }
}