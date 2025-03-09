class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int result = 0;
        int countTrue = 0;
        int n = colors.length;

        for (int index = 0; index < n-1 + k; index++ ) {
            int i = index % n;
            if (colors[i] == colors[(i+1)%n]) {
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