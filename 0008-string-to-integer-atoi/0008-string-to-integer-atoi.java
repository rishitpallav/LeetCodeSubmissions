class Solution {
    public int myAtoi(String s) {

        StringBuilder resultString = new StringBuilder();
        int index = 0;

        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        if (index == s.length()) {
            return 0;
        }

        boolean isNegative = false;
        if (s.charAt(index) == '-') {
            isNegative = true;
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        }

        while (index < s.length() && s.charAt(index) == '0') {
            index++;
        }

        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            resultString.append(s.charAt(index++));
        }

        if (resultString.length() == 0) {
            return 0;
        }

        if (resultString.length() < 10) {
            return (isNegative ? -1 : 1) * Integer.parseInt(resultString.toString());
        }

        if (resultString.length() > 10) {
            return isNegative ? -2147483648 : 2147483647;
        }

        int lastDigits = 214748364;
        int originalDigits = Integer.parseInt(resultString.substring(0,9).toString());
        if (lastDigits > originalDigits) {
            return (isNegative ? -1 : 1) * Integer.parseInt(resultString.toString());
        } else if (lastDigits == originalDigits) {
            if (isNegative) {
                if (resultString.charAt(resultString.length()-1) < '8') {
                    return -1 * Integer.parseInt(resultString.toString());
                } else {
                    return -2147483648;
                }
            } else {
                if (resultString.charAt(resultString.length()-1) < '7') {
                    return Integer.parseInt(resultString.toString());
                } else {
                    return 2147483647;
                }
            }
        } else {
            return isNegative ? -2147483648 : 2147483647;
        }
    }
}