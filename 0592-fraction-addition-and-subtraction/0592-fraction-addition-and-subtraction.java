class Solution {
    public String fractionAddition(String expression) {
        int[] values = Arrays.stream(expression.split("/|(?=[-+])")).mapToInt(Integer::parseInt).toArray();

        int num = values[0], den = values[1];
        int index = 2;

        for (int i = 2; i < values.length; i += 2) {
            int nextNum = values[i];
            int nextDen = values[i+1];

            if (num == 0) {
                num = nextNum;
                den = nextDen;
            } else if (den == nextDen) {
                num = num + nextNum;
            } else {
                int temp = den;
                den *= nextDen;
                num *= nextDen;
                nextNum *= temp;

                num = num + nextNum;
            }
        }

        /*=
            10/15 => 15%10 = 5 => 10/5 = 2, 15/5 = 3.
        */

        int gcd = gcd(Math.abs(num), den);
        num /= gcd;
        den /= gcd;

        if (den < 0) {
            num = -num;
            den = -den;
        }

        return num+"/"+den;
    }

    int gcd (int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }
}