class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int left = 0, total = 0, result = 0;

        for (int right = 0; right < nums.length; right++ ) {
            total += nums[right];

            while (total > goal) {
                total -= nums[left++];
            }

            int tempLeft = left;
            int tempSum = total;
            while (tempLeft <= right && tempSum == goal) {
                result++;
                tempSum -= nums[tempLeft++];
            }
        }

        return result;
    }
}