class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;
        Arrays.sort(nums);
        k--;

        int result = nums[k] - nums[0];
        
        for (int i = k; i < nums.length; i++ ) {
            result = Math.min(result, nums[i] - nums[i-k]);
        }

        return result;
    }
}