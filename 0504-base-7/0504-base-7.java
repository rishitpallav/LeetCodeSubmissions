class Solution {
    public String convertToBase7(int num) {

        if (num == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        int carry = 0;
        boolean isNeg = num < 0;
        num = Math.abs(num);

        while (num > 0) {
            result.append(num%7);
            num /= 7;
        }
        if (isNeg) {
            result.append("-");
        }

        return result.reverse().toString();
    }
}