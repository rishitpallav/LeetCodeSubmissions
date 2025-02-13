class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);

        int i = 0;

        while (k > 0 && i < nums.length && nums[i] < 0) {
            nums[i] *= -1;
            k--;
            i++;
        }

        if (i >= nums.length) {
            i = nums.length - 1;
        }

        if (k %2 != 0) {
            if (nums[i] < 0 || i == 0 || nums[i] < nums[i-1]) {
                nums[i] *= -1;
            } else {
                nums[i-1] *= -1;
            }
        }

        int sum = 0;
        for (int x : nums) {
            sum += x;
        }

        return sum;
    }
}