class Solution {
    public int minOperations(int[] nums) {
        int result = 0;

        for (int i = 1; i < nums.length; i++ ) {
            int diff = nums[i] - nums[i-1];
            if (diff <= 0) {
                diff *= -1;
                result += diff + 1;
                nums[i] = nums[i-1] + 1;
            }
        }

        return result;
    }
}