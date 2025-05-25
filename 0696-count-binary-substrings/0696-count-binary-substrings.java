class Solution {
    public int countBinarySubstrings(String s) {
        int left = 0, result = 0;
        boolean leftZeros = true;
        char[] chars = s.toCharArray();

        for (int right = 1; right < chars.length; right++ ) {
            left = right - 1;
            leftZeros = (chars[left] == '0')? true : false;

            while ((left >= 0) && (right < chars.length) && (chars[left] != chars[right]) && (((leftZeros) && chars[right] == '1') || ((!leftZeros) && chars[right] == '0'))) {
                left--;
                right++;
                result++;
            }
            if (right - left > 1) {
                right--;
            }
        }

        return result;
    }
}