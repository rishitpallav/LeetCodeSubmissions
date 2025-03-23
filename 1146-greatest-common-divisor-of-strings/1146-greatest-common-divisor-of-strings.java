class Solution {
    public String gcdOfStrings(String str1, String str2) {

        String shorter = str1;
        String longer = str2;

        if (str1.length() > str2.length()) {
            shorter = str2;
            longer = str1;
        }

        int n = shorter.length();

        boolean dividesLonger = false;

        while (!dividesLonger && n > 0) {
            while (n % shorter.length() != 0 && n % longer.length() != 0 && !isDivisor(n, shorter, shorter)) {
                n--;
                if (n == 0) return "";
            }

            dividesLonger = isDivisor(n, shorter, longer);
            if (!dividesLonger)
                n--;
        }

        return shorter.substring(0, n);
        
    }

    boolean isDivisor(int n, String shorter, String longer) {
        int i = 0, j = 0;
        for (; i < longer.length(); i++, j++ ) {
            j = j%n;
            if (longer.charAt(i) != shorter.charAt(j)) {
                return false;
            }
        }
        return j == n;
    }
}