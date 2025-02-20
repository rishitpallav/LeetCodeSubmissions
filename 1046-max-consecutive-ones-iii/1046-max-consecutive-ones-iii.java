class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeros = 0;
        int ones = 0;

        int left = 0;
        int max = 0;

        for (int n : nums) {
            if (n == 0) {
                zeros++;
            } else {
                ones++;
            }

            while (zeros > k) {
                if (nums[left++] == 0) {
                    zeros--;
                } else {
                    ones--;
                }
            }
            max = Math.max(max, zeros + ones);
        }

        return max;
    }
}