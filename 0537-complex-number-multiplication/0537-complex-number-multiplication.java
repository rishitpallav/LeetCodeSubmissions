class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int[] arr1 = splitValues(num1);
        int[] arr2 = splitValues(num2);

        int real = (arr1[0] * arr2[0]) + (-1 * arr1[1] * arr2[1]);
        int imaginary = (arr1[0] * arr2[1]) + (arr1[1] * arr2[0]);

        return real + "+" + imaginary + "i";
    }

    int[] splitValues(String s) {
        int i = 0;
        
        int x1 = 0;
        boolean isX1Neg = false;
        if (s.charAt(i) == '-') {
            isX1Neg = true;
            i++;
        }
        while (s.charAt(i) != '+') {
            x1 *= 10;
            x1 += s.charAt(i) - '0';
            i++;
        }
        i++;

        int x2 = 0;
        boolean isX2Neg = false;
        if (s.charAt(i) == '-') {
            isX2Neg = true;
            i++;
        }
        while (s.charAt(i) != 'i') {
            x2 *= 10;
            x2 += s.charAt(i) - '0';
            i++;
        }

        return new int[]{(isX1Neg? -1 : 1) * x1, (isX2Neg? -1 : 1) * x2};

    }
}