class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i-- ) {
            carry += digits[i];
            digits[i] = carry %10;
            carry /= 10;
        }

        if (carry == 0) {
            return digits;
        }

        int[] result = new int[digits.length + 1];
        System.arraycopy(digits, 0, result, 1, result.length-1);
        result[0] = carry;
        return result;
    }
}