class Solution {
    public int maxSubArray(int[] nums) {
        int largestSum = nums[0], currentSum = 0;

        for (int num : nums) {
            currentSum += num;
            largestSum = Math.max(currentSum, largestSum);

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return largestSum;
    }
}