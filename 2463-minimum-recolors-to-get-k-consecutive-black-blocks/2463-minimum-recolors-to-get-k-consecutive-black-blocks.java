class Solution {
    public int minimumRecolors(String blocks, int k) {
        int countW = 0;
        int countB = 0;
        
        int left = 0;

        int i = 0;
        for (; i < k; i++ ) {
            if (blocks.charAt(i) == 'W') {
                countW++;
            } else {
                countB++;
            }
        }

        int result = countW;

        for (; i < blocks.length(); i++ ) {
            if (blocks.charAt(i) == 'W') {
                countW++;
            } else {
                countB++;
            }

            if (blocks.charAt(left) == 'W') {
                countW--;
            } else {
                countB--;
            }
            left++;
            result = Math.min(result, countW);
        }

        return result;
    }
}