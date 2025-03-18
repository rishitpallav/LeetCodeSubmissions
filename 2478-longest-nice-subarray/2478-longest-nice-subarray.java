class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0;
        int result =0;
        int counter = 0;

        for (int right = 0; right < nums.length; right++ ) {
            while ((nums[right] & counter) != 0) {
                counter ^= nums[left++];
            }
            counter = counter | nums[right];
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}