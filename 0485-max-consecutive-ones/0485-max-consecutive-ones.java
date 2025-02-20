class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int counter = 0;
        int maxLength = 0;

        for (int n : nums) {
            if (n == 0) counter = 0;
            else {
                counter++;
                maxLength = Math.max(maxLength, counter);
            }
        }

        return maxLength;
    }
}