class Solution {
    public int maxProduct(int[] nums) {
        int max = 1;
        int min = 1;
        int result = nums[0];

        for (int i = 0; i < nums.length; i++ ) {
            int previousMax = max * nums[i];
            max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(min * nums[i], previousMax));
            result = Math.max(result, max);
        }

        return result;
    }
}
