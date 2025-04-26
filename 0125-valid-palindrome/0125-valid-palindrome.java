class Solution {
    public boolean isPalindrome(String s) {

        /*
        1. Reverse the entire string and compare each character, skipping the non alphanumeric characters. - O(n) + O(n)
        2. Use a stack and keep checking the previous characters - o(n^2)
        3. two pointer - O(n) we only need to get till the middle, it is not a log(n) solution
        */

        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (left >= right) {
                return true;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}