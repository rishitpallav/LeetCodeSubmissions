class Solution {
    public int minMaxDifference(int num) {
        char large = ' ';
        char small = ' ';

        String value = String.valueOf(num);

        for (int i = 0; i < value.length() && (large == ' ' || small == ' '); i++ ) {
            if (large == ' ' && value.charAt(i) != '9') {
                large = value.charAt(i);
            }
            if (small == ' ' && value.charAt(i) != '0') {
                small = value.charAt(i);
            }
        }

        int result = 0;
        for (int i = 0; i < value.length(); i++ ) {
            char c = value.charAt(i);
            if (c == small) {
                result *= 10;
                result += 9;
            } else {
                if (c == large) {
                    result *= 10;
                    result += '9' - c;
                } else {
                    result *= 10;
                }
            }
        }

        return result;
    }
}