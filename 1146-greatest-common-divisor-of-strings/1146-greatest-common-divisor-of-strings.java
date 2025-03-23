class Solution {
    public String gcdOfStrings(String str1, String str2) {

        String shorter = str1;
        String longer = str2;

        if (str1.length() > str2.length()) {
            shorter = str2;
            longer = str1;
        }

        StringBuilder divisor = new StringBuilder(shorter);

        boolean dividesLonger = false;

        while (!dividesLonger && divisor.length() > 0) {
            while (!isDivisor(divisor, shorter)) {
                divisor.deleteCharAt(divisor.length() - 1);
                if (divisor.length() == 0) return "";
            }

            dividesLonger = isDivisor(divisor, longer);
            if (!dividesLonger)
                divisor.deleteCharAt(divisor.length() - 1);
        }

        return divisor.toString();
        
    }

    boolean isDivisor(StringBuilder shorter, String longer) {
        int i = 0, j = 0;
        int n = shorter.length();
        for (; i < longer.length(); i++, j++ ) {
            j = j%n;
            if (longer.charAt(i) != shorter.charAt(j)) {
                return false;
            }
        }
        return j == shorter.length();
    }
}