class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int temp = x;
        int reversedInteger = 0;

        while (temp > 0) {
            reversedInteger *= 10;
            reversedInteger += temp%10;
            temp /= 10;
        }

        return reversedInteger == x;
    }
}