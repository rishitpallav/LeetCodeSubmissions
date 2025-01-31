class Solution {
    public int reverse(int x) {
    
        int reversed = 0;
        int i = 0;

        while (x != 0) {
            int temp = x%10;
            x /= 10;

            if (reversed > Integer.MAX_VALUE/10 || (reversed == Integer.MAX_VALUE/10 && temp > 7)) {
                return 0;
            }

            if (reversed < Integer.MIN_VALUE/10 || (reversed == Integer.MIN_VALUE/10 && temp < -8)) {
                return 0;
            }

            reversed = reversed * 10 + temp;
            i++;
        }

        return reversed;
    }
}