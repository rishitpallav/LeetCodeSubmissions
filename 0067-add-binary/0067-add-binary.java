class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int n = a.length() -1;
        int m = b.length() -1;
        int carry = 0;

        while (n >= 0 || m>= 0) {
            int countOnes = 0;
            if (n >= 0 && a.charAt(n) == '1') {
                countOnes++;
            }
            if ( m >= 0 && b.charAt(m) == '1') {
                countOnes++;
            }
            n--;
            m--;
            countOnes += carry;

            if (countOnes == 3) {
                sb.insert(0, "1");
                carry = 1;
            } else if (countOnes == 2) {
                sb.insert(0, "0");
                carry = 1;
            } else if (countOnes == 1) {
                sb.insert(0,"1");
                carry = 0;
            } else {
                sb.insert(0,"0");
            }
        }

        if (carry == 1) {
            sb.insert(0, "1");
        }

        return sb.toString();
    }
}